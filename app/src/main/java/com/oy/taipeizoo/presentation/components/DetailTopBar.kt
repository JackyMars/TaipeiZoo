package com.oy.taipeizoo.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oy.taipeizoo.R

@Composable
fun DetailTopBar(
    navigationController: NavController
)
{
    TopAppBar(
        title = {
        },
        navigationIcon = {
            IconButton(onClick = {
                navigationController.navigate(R.id.action_detailFragment_to_listFragment)
            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = Color.LightGray,
        contentColor = Color.White,
        elevation = 10.dp
    )
}