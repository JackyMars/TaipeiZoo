package com.oy.taipeizoo.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.repository.AnimalLocationRepository
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

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
    val query = mutableStateOf("大貓熊")

    init {
        newSerach()
        getLocation()
    }

    fun newSerach(){
        viewModelScope.launch {
            val result = repository.serach(
                query = query.value,
                offset = 21,
                limit = 40
            )
            animals.value = result
        }
    }
    fun testSerach(){
        viewModelScope.launch {
            val result = repository.serach(
                query = query.value,
                offset = 31,
                limit = 10
            )
            animals.value = result
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