package com.oy.taipeizoo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.presentation.ui.IMAGE_HEIGHT
import com.oy.taipeizoo.util.DEFAULT_IMAGE
import com.oy.taipeizoo.util.loadPicture

@Composable
fun AnimalDetail(
    animal:AnimalInfo,

) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        item {
            val image = loadPicture(url = animal.url, defaultImage = DEFAULT_IMAGE).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Recipe Featured Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IMAGE_HEIGHT.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                ) {
                        Text(
                            text = animal.name_ch,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h4

                        )

                        Text(
                            text = animal.location,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h6

                        )

                        Text(
                            text = animal.a_phylum,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h6

                        )

                        Text(
                            text = animal.a_class,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h6

                        )

                        Text(
                            text = animal.a_order,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h6

                        )

                        Text(
                            text = animal.a_family,
                            modifier = Modifier.fillMaxWidth(0.85f),
                            style = MaterialTheme.typography.h6

                        )
                        Text(
                            text = "形態特徵:",
                            color = Color.Gray,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = animal.feature,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.h6

                        )
                        Text(
                            text = "生態習性:",
                            color = Color.Gray,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = animal.behavior,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.h6

                        )
                        Text(
                            text = "地理分布:",
                            color = Color.Gray,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = animal.distribution,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.h6

                        )

                }

            }
        }
    }
}