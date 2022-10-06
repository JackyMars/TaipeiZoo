package com.oy.taipeizoo.presentation.ui.list

sealed class ListEvent {

    object newSerachAndInsertDbEvent:ListEvent()
    object newLocationEvent:ListEvent()
    object queryByLocationEvent:ListEvent()
    object queryByNameEvent:ListEvent()
}