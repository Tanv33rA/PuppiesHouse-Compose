/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.data.PuppyDog
import com.example.androiddevchallenge.data.PuppyDogList
import com.example.androiddevchallenge.data.detailsLoremIpsum
import com.example.androiddevchallenge.ui.navigation.getArg
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.gray200
import com.example.androiddevchallenge.ui.theme.purple500
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun DetailsScreen(navController: NavHostController) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxHeight(), color = gray200) {
            val dogItemIndex = navController.getArg("index")
            val puppyDog: PuppyDog = PuppyDogList[dogItemIndex!!]
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Puppy Details",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    CoilImage(data = puppyDog.image) { imageLoadState ->
                        when (imageLoadState) {
                            is ImageLoadState.Success -> {
                                MaterialLoadingImage(
                                    result = imageLoadState,
                                    contentDescription = "This is description",
                                    fadeInEnabled = true,
                                    fadeInDurationMs = 600,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                        .padding(15.dp)
                                        .clip(shape = RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop,
                                    skipFadeWhenLoadedFromMemory = true,
                                    alignment = Alignment.Center
                                )
                            }
                            is ImageLoadState.Error -> Text(text = "Loading")
                            is ImageLoadState.Loading -> Text(text = "Loading")
                            is ImageLoadState.Empty -> Text(text = "Loading")
                            else -> {
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = puppyDog.breed,
                            modifier = Modifier
                                .width(150.dp)
                                .padding(top = 5.dp, bottom = 5.dp, start = 30.dp, end = 30.dp)
                                .border(1.dp, purple500, shape = RoundedCornerShape(16.dp))
                                .padding(5.dp),
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = puppyDog.age.toString() + " years old",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp, bottom = 5.dp, start = 30.dp, end = 30.dp)
                                .border(1.dp, purple500, shape = RoundedCornerShape(16.dp))
                                .padding(5.dp),
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    }

                    Text(
                        text = "Details:",
                        modifier = Modifier.padding(2.dp),
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = detailsLoremIpsum,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Justify,
                    )

                    Text(
                        text = "Adopt Me",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 5.dp, start = 30.dp, end = 30.dp)
                            .border(1.dp, purple500, shape = RoundedCornerShape(16.dp))
                            .padding(5.dp),
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 600,
    widthDp = 600
)
@Composable
fun PreviewDetailsScreen() {
    AppTheme {
        DetailsScreen(NavHostController(LocalContext.current))
    }
}
