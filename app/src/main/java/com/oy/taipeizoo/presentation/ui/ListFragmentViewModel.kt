package com.oy.taipeizoo.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.repository.AnimalLocationRepository
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    val query = mutableStateOf("臺灣動物區")

    init {
        getApiDataAndInsertDb()
        getLocation()
//        QueryByLocation(query.value)
    }

    fun getApiDataAndInsertDb(){
        viewModelScope.launch {
            val result = repository.serach(
                query = query.value,
                offset = 0,
                limit = 300
            )
//            animals.value = result
            repository.insertAnimals(result)
        }
    }
    fun QueryByLocation(location:String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.findAnimalsByLocation(location = location)
            animals.value  = result
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
}