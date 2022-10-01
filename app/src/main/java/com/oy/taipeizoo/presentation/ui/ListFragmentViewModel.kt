package com.oy.taipeizoo.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ListFragmentViewModel
@Inject
constructor(
    private val repository: AnimalRepository
)
:ViewModel() {

    val animals : MutableState<List<AnimalInfo>> = mutableStateOf(listOf())

    init {
        newSerach()
    }

    fun newSerach(){
        viewModelScope.launch {
            val result = repository.serach(
                query = "",
                offset = 0,
                limit = 20
            )
            animals.value = result
        }
    }
}