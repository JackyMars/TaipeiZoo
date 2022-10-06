package com.oy.taipeizoo.presentation.ui.list

sealed class ListEvent {

    data class queryByNameEvent(
        val name:String
    ):ListEvent()
    object newSerachAndInsertDbEvent:ListEvent()
    object newLocationEvent:ListEvent()
    object queryByLocationEvent:ListEvent()
}