package com.oy.taipeizoo.presentation.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.oy.taipeizoo.R
import com.oy.taipeizoo.presentation.components.AnimalCard
import com.oy.taipeizoo.presentation.components.CircularIndeterminateProgressBar
import com.oy.taipeizoo.presentation.components.SearchAppBar
import com.oy.taipeizoo.presentation.ui.list.ListEvent
import com.oy.taipeizoo.presentation.ui.list.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.oy.taipeizoo.presentation.ui.list.ListEvent.*

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

                Column{
                    SearchAppBar(
                        query = query,
                        onExecuteSearch = {viewModel.onTriggerEvent(queryByLocationEvent)},
                        onQueryChange =  viewModel::onQueryChange,
                        onLocationChange = viewModel::onLocationChange ,
                        locations =  locations,
                        state = state,
                        focusManager = focusManager
                    )
                    CircularIndeterminateProgressBar(isDisplayed = loading)

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
            }
        }
    }


}