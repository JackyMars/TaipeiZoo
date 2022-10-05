package com.oy.taipeizoo.presentation.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.oy.taipeizoo.R
import com.oy.taipeizoo.presentation.components.AnimalCard
import com.oy.taipeizoo.presentation.components.CircularIndeterminateProgressBar
import com.oy.taipeizoo.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(){

    private val viewModel:ListFragmentViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val animals = viewModel.animals.value
                val query = viewModel.query.value

                val focusManager = LocalFocusManager.current
                val state = viewModel.selectedLocation
                val locations = viewModel.locations.value
                val loading = viewModel.loading.value

                Column{
                    SearchAppBar(
                        query = query,
                        onQueryChange =  viewModel::onQueryChange,
                        QueryByLocation = viewModel::QueryByLocation,
                        locations =  locations,
                        state = state,
                        focusManager = focusManager,
                        onSelectedLocation= viewModel::onSelectedLocation
                    )
                    CircularIndeterminateProgressBar(isDisplayed = loading)

                    LazyColumn{
                        itemsIndexed(
                            items = animals
                        ){index, item ->
                            AnimalCard(animal = item, onClick = {})
                        }
                    }
                }
            }
        }
    }


}