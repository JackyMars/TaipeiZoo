package com.oy.taipeizoo.presentation.ui.deatil

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.oy.taipeizoo.presentation.ui.deatil.DetailEvent.GetAnimalEvent
import kotlinx.coroutines.delay

const val STATE_KEY_ANIMAL = "detail.state.animal.key"

@HiltViewModel
class DetailFragmentViewModel
@Inject
constructor(
    private val repository: AnimalRepository,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    val animal:MutableState<AnimalInfo?> = mutableStateOf(null)

    val loading = mutableStateOf(false)

    init {

        savedStateHandle.get<Int>(STATE_KEY_ANIMAL)?.let{ animalId ->
            onTriggerEvent(GetAnimalEvent(animalId))
        }
    }

    fun onTriggerEvent(event:DetailEvent){

        viewModelScope.launch {
            try{

                when(event){
                    is GetAnimalEvent -> {
                        if(animal.value == null){
                            Log.d("APPDEBUG", "onTriggerEvent: ${animal.value}")
                            getAnimal(event.id)
                        }
                    }
                }

            }catch (e:Exception){
                Log.e("DetailFragmentViewModel", "onTriggerEvent:${e},${e.cause} ", )
            }
        }

    }
    private suspend fun getAnimal(id:Int){

        loading.value = true

        delay(1000)

        val result = repository.findAnimalById(id)

        this.animal.value = result

        savedStateHandle.set(STATE_KEY_ANIMAL,result.id)

        loading.value = false
    }

}