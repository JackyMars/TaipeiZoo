package com.oy.taipeizoo.presentation.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.repository.AnimalLocationRepository
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ListFragmentViewModel
@Inject
constructor(
    private val repository: AnimalRepository,
    private val repository_location:AnimalLocationRepository
)
:ViewModel() {

    val animals : MutableState<List<AnimalInfo>> = mutableStateOf(listOf())
    val locations:MutableState<List<AnimalLocationInfo>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val loading = mutableStateOf(false)

    val selectedLocation : MutableState<Int?> = mutableStateOf(null)

    init {
        getApiDataAndInsertDb()
        getLocation()

//        QueryByLocation("臺灣動物區")
    }

    fun getApiDataAndInsertDb(){
        viewModelScope.launch {
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
    }
    fun QueryByLocation(location:String){

        viewModelScope.launch(Dispatchers.IO) {
            loading.value = true

            val result = repository.findAnimalsByLocation(
                location = location
            )
            animals.value  = result

            for(animal in animals.value){
                Log.d("APPDEBUG", "QueryByLocation: ${animal.name_ch}")
            }

            loading.value = false
        }
    }
    fun onQueryChange(query:String){
         this.query.value = query
    }
    fun getLocation(){
        viewModelScope.launch {

            var result = repository_location.get()

            locations.value = result

        }
    }
    fun onSelectedLocation(location: String){
        QueryByLocation(location)
        onQueryChange(location)
    }
    private fun reSet(){
        animals.value = listOf()
        clearSelectedLocation()
    }
    private fun clearSelectedLocation(){
        selectedLocation.value = null
    }
}