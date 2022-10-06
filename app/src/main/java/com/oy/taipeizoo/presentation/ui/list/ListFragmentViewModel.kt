package com.oy.taipeizoo.presentation.ui.list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.repository.AnimalLocationRepository
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.oy.taipeizoo.presentation.ui.list.ListEvent.*
import kotlin.math.log

const val STATE_KEY_QUERY = "list.state.query.key"
const val STATE_KEY_LOCATION = "list.state.location.key"

@HiltViewModel
class ListFragmentViewModel
@Inject
constructor(
    private val repository: AnimalRepository,
    private val repository_location:AnimalLocationRepository,
    private val savedStateHandle: SavedStateHandle
)
:ViewModel() {

    val animals : MutableState<List<AnimalInfo>> = mutableStateOf(listOf())
    val locations:MutableState<List<AnimalLocationInfo>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val location = mutableStateOf("")
    val loading = mutableStateOf(false)

    val selectedLocation : MutableState<Int?> = mutableStateOf(null)

    init {

        onTriggerEvent(newSerachAndInsertDbEvent)
        onTriggerEvent(newLocationEvent)

        savedStateHandle.get<String>(STATE_KEY_QUERY)?.let { q ->
            setQuery(q)
        }
        savedStateHandle.get<String>(STATE_KEY_LOCATION)?.let { l ->
            setLocation(l)
        }

    }

    fun onTriggerEvent(event: ListEvent){
        viewModelScope.launch {
            try{
                when(event){
                    is newSerachAndInsertDbEvent -> {
                        getApiDataAndInsertDb()
                    }
                    is newLocationEvent -> {
                        getLocation()
                    }
                    is queryByLocationEvent -> {
                        queryByLocation()
                    }
                    is queryByNameEvent -> {
                            //to do
                    }
                }
            }catch (e:Exception){
                Log.e("ListFragmentViewModel", "onTriggerEvent: ${e},${e.cause}", )
            }
        }
    }




    private suspend fun getApiDataAndInsertDb(){

        loading.value = true
        reSet()
        delay(2000)

        val result = repository.serach(
            query = query.value,
            offset = 0,
            limit = 300
        )
        animals.value = result
        repository.insertAnimals(result)

        loading.value = false
    }

    private suspend fun queryByLocation(){

        loading.value = true
        val result = repository.findAnimalsByLocation(
            location = location.value
        )

        animals.value  = result

        loading.value = false

    }
    private suspend fun getLocation(){

        var result = repository_location.get()

        locations.value = result

    }
    fun onQueryChange(query:String){
        Log.d("APPDEBUG", "onQueryChange: ${query}")
        setQuery(query)
    }
    fun onLocationChange(location: String){
        Log.d("APPDEBUG", "onLocationChange: ${location}")
        setLocation(location)
    }

    private fun reSet(){
        animals.value = listOf()
        clearSelectedLocation()
    }
    private fun clearSelectedLocation(){
        selectedLocation.value = null
    }
    private fun setQuery(query: String){
        this.query.value = query
        savedStateHandle.set(STATE_KEY_QUERY, query)
    }
    private fun setLocation(location:String){
        this.location.value = location
        savedStateHandle.set(STATE_KEY_LOCATION,location)

    }
}