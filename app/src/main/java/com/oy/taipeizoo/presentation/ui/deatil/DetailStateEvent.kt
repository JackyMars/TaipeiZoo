package com.oy.taipeizoo.presentation.ui.deatil

sealed class DetailEvent {

    data class GetAnimalEvent(
        val id:Int
    ):DetailEvent()
}