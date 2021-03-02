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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyDog
import com.example.androiddevchallenge.ui.theme.purple500
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun DogCard(
    dog: PuppyDog,
    onClick: (PuppyDog) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp, start = 5.dp, end = 5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                onClick.invoke(dog)
            }

    ) {
        Surface(color = Color.White) {
            Row {
                CoilImage(data = dog.image) { imageLoadState ->
                    when (imageLoadState) {
                        is ImageLoadState.Success -> {
                            MaterialLoadingImage(
                                result = imageLoadState,
                                contentDescription = "This is description",
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                                    .clip(shape = RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop,
                                skipFadeWhenLoadedFromMemory = true,
                                alignment = Alignment.Center
                            )
                        }
                        is ImageLoadState.Error -> Text(text = "Error")
                        is ImageLoadState.Loading -> Text(text = "Loading")
                        is ImageLoadState.Empty -> Text(text = "Loading")
                        else -> {
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = dog.breed,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        style = MaterialTheme.typography.h5,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = dog.sex,
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

@Preview
@Composable
fun PreviewDog() {
    Surface() {
        DogCard(
            dog = PuppyDog(101, "", "", 16, "", "", "male", "2kg"),
            onClick = { }
        )
    }
}
