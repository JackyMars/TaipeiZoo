package com.oy.taipeizoo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oy.taipeizoo.BuildConfig
import com.oy.taipeizoo.domain.model.AnimalLocationInfo


@Composable
fun SearchAppBar(
    query: String,
    onExecuteSearch: () -> Unit,
    onExecuteSearchName: () -> Unit,
    onQueryChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    locations:  List<AnimalLocationInfo>,
    state: MutableState<Int?>,
    focusManager: FocusManager,
    showMenu:MutableState<Boolean>

) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        elevation = 8.dp
    ) {

        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp)
                        .background(color = MaterialTheme.colors.surface),
                    value = query,
                    onValueChange = { newValue ->
                        onQueryChange(newValue)
                        onExecuteSearchName()
                    },
                    label = {
                        Text(text = "搜尋")
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onQueryChange(query)
                            onExecuteSearchName()
                            focusManager.clearFocus()
                        }
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text
                    ),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Localized description")
                    },
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),


                    )
                    Box(
                        modifier = Modifier.weight(1f).padding(top = 8.dp, end = 5.dp)
                     ){
                        IconButton(onClick = { showMenu.value = !showMenu.value }) {
                            Icon(Icons.Default.MoreVert, "")
                        }
                        DropdownMenu(
                            expanded = showMenu.value,
                            onDismissRequest = { showMenu.value = false }) {
                            DropdownMenuItem(onClick = { }) {
                                Text(text = "版本號:" + BuildConfig.VERSION_NAME)
                        }
                    }
                }

            }

            if(locations.size > 0){
                ScrollableTabRow(
                    selectedTabIndex = state.value?:0,
                    modifier = Modifier.wrapContentWidth(),
                    edgePadding = 16.dp,
                    backgroundColor = Color.LightGray

                ) {
                    locations.forEachIndexed{index, location ->
                        Tab(
                            text = { Text(location.name) },
                            selected = state.value == index,
                            selectedContentColor = Color.DarkGray,
                            unselectedContentColor = Color.White,
                            onClick = {
                                state.value = index
                                onLocationChange(location.name)
                                onQueryChange(location.name)
                                onExecuteSearch()
                            }
                        )
                    }
                }
            }

        }

    }
}