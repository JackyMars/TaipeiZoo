package com.oy.taipeizoo.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.oy.taipeizoo.R
import com.oy.taipeizoo.presentation.ui.list.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.oy.taipeizoo.presentation.ui.list.ListEvent.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.oy.taipeizoo.presentation.components.*


@AndroidEntryPoint
class ListFragment : Fragment(){

    private val viewModel: ListFragmentViewModel by viewModels()
    
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

                val scaffoldState = rememberScaffoldState()
                var showMenu = remember { mutableStateOf(false) }

                Scaffold(
                    topBar = {

                        SearchAppBar(
                            query = query,
                            onExecuteSearch = {viewModel.onTriggerEvent(queryByLocationEvent)},
                            onExecuteSearchName = {viewModel.onTriggerEvent(queryByNameEvent)},
                            onQueryChange =  viewModel::onQueryChange,
                            onLocationChange = viewModel::onLocationChange ,
                            locations =  locations,
                            state = state,
                            focusManager = focusManager,
                            showMenu = showMenu
                        )

                    },
                    scaffoldState = scaffoldState
                ){

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colors.surface)

                    ){
                        if(loading){

                            LoadingRecipeListShimmer(
                                imageHeight = 250.dp
                            )

                        }else{
                            LazyColumn{
                                itemsIndexed(
                                    items = animals
                                ){index, item ->
                                    AnimalCard(
                                        animal = item,
                                        onClick = {
                                            if(item.id != null){
                                                val bundle = Bundle()
                                                bundle.putInt("animalId",item.id)
                                                findNavController().navigate(
                                                    R.id.action_listFragment_to_detailFragment,
                                                    bundle
                                                )
                                            }
                                        })
                                }
                            }
                        }
                        CircularIndeterminateProgressBar(isDisplayed = loading,verticalBias=0.5f)


                    }
                }

            }
        }
    }

}



