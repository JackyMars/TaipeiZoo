package com.oy.taipeizoo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.oy.taipeizoo.presentation.components.AnimalDetail
import com.oy.taipeizoo.presentation.components.CircularIndeterminateProgressBar
import com.oy.taipeizoo.presentation.components.DetailTopBar
import com.oy.taipeizoo.presentation.components.LoadingAnimalShimmer
import com.oy.taipeizoo.presentation.ui.deatil.DetailEvent
import com.oy.taipeizoo.presentation.ui.deatil.DetailFragmentViewModel
import com.oy.taipeizoo.util.DEFAULT_IMAGE
import com.oy.taipeizoo.util.loadPicture
import dagger.hilt.android.AndroidEntryPoint
import com.oy.taipeizoo.presentation.ui.deatil.DetailEvent.GetAnimalEvent

const val IMAGE_HEIGHT = 260

@AndroidEntryPoint
class DetailFragment :Fragment() {

    private val viewModel: DetailFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt("animalId")?.let { aid ->
           viewModel.onTriggerEvent(GetAnimalEvent(aid))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value

                val animal = viewModel.animal.value

                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    topBar = {
                        DetailTopBar(
                            navigationController = findNavController()
                        )
                    },
                    scaffoldState = scaffoldState
                ){
                    Box(modifier = Modifier.fillMaxSize()){
                        if (loading && animal == null) {
                            LoadingAnimalShimmer(IMAGE_HEIGHT.dp)
                        }else{
                            animal?.let {
                                AnimalDetail(it)
                            }

                        }
                        CircularIndeterminateProgressBar(isDisplayed = loading,verticalBias=0.5f)
                    }


                }

            }
        }
    }
}