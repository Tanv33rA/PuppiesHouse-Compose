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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.PuppyDog
import com.example.androiddevchallenge.data.PuppyDogList
import com.example.androiddevchallenge.ui.components.DogCard
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.navigation.addArg
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.gray200

@Composable
fun MainScreen(navController: NavHostController) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxHeight(), color = gray200) {
            Column(modifier = Modifier.fillMaxWidth()) {
                HeaderViewComposeAble()
                DogPuppies(PuppyDogList, navController)
            }
        }
    }
}

@Composable
fun HeaderViewComposeAble() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(id = com.example.androiddevchallenge.R.drawable.pupy_icon),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .padding(5.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "Puppies House",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h5,
            color = Color.Black,
        )
    }
}

@Composable
fun DogPuppies(dogs: List<PuppyDog>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        itemsIndexed(dogs) { index, item ->
            DogCard(
                dog = item,
                onClick = { puppyDog ->
                    navController.addArg(puppyDog.id)
                    navController.navigate(Screen.Details.route)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 240,
    widthDp = 240
)
@Composable
fun PreviewHomeScreen() {
    AppTheme {
        MainScreen(NavHostController(LocalContext.current))
    }
}
