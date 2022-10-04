package com.oy.taipeizoo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oy.taipeizoo.domain.model.AnimalLocationInfo


@Composable
fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    QueryByLocation: (String) -> Unit,
    locations:  List<AnimalLocationInfo>,
    state: MutableState<Int>,
    focusManager: FocusManager,
    onSelectedLocation: (String) -> Unit

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
                    },
                    label = {
                        Text(text = "搜尋")
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            QueryByLocation(query)
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

            }

            if(locations.size > 0){
                ScrollableTabRow(
                    selectedTabIndex = state.value,
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
                                onSelectedLocation(location.name)
                            }
                        )
                    }
                }
            }

        }

    }
}