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
package com.example.androiddevchallenge.data

data class PuppyDog(
    val id: Int,
    val name: String,
    val breed: String,
    val age: Int,
    val image: String,
    val color: String,
    val sex: String,
    val weight: String,
)

val imagesList = listOf(
    "https://i.pinimg.com/originals/de/06/30/de0630ac84cbe27020cad1ece6d5f5cf.jpg",
    "https://spot-and-tango.s3.amazonaws.com/production/media/Norfolk_Terrier_2019-08-29T202943.jpg",
    "https://images.ctfassets.net/440y9b545yd9/4vQ3LsO3XQvNmmPmspFViT/2ad244c19674f267f500ea77e69bc84c/Boxer_dog850.jpg",
    "https://i.pinimg.com/originals/21/cc/0e/21cc0ef668b35d78ff3e7160fd556186.jpg",
    "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/18182350/Drever-face.jpg",
    "https://vetstreet.brightspotcdn.com/dims4/default/999a79d/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F85%2Fde4620aec211e088ab0050568d634f%2Ffile%2FChug-1-645km071411.jpg",
    "https://upload.wikimedia.org/wikipedia/commons/2/2b/WelshCorgi.jpeg",
    "https://www.indiantrailanimalhospital.com/sites/default/files/styles/large/public/golden-retriever-dog-breed-info.jpg?itok=XjcldPnx",
    "https://www.perfectdogbreeds.com/wp-content/uploads/2019/03/Morkie-Breed-Information-The-Pet-Parents-Complete-Guide-Cover.jpg",
    "https://i.pinimg.com/originals/2b/cd/15/2bcd159c1a914a71bedb00beeeb14ec4.jpg"
)

val PuppyDogList = listOf(
    PuppyDog(0, "Carmen", "Barbet", 1, imagesList[0], "White", "Male", "2KG"),
    PuppyDog(1, "Lola", "Terrier", 2, imagesList[1], "Black", "Male", "2KG"),
    PuppyDog(2, "Coco", "Boxer", 1, imagesList[2], "White", "Male", "2KG"),
    PuppyDog(3, "Wand", "Pug", 2, imagesList[3], "White", "Male", "2KG"),
    PuppyDog(4, "Nugget", "Drev", 2, imagesList[4], "Black", "Female", "2KG"),
    PuppyDog(5, "Sugar", "Chug", 1, imagesList[5], "White", "Male", "2KG"),
    PuppyDog(6, "Charlie", "Dorgi", 1, imagesList[6], "White", "Male", "2KG"),
    PuppyDog(7, "Max", "Golden", 1, imagesList[7], "Black", "Male", "2KG"),
    PuppyDog(8, "Buddy", "Morkie", 2, imagesList[8], "White", "Male", "2KG"),
    PuppyDog(9, "Teddy", "Pug", 1, imagesList[9], "White", "Male", "2KG")
)

val detailsLoremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the " +
    "industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it " +
    "to make a type specimen book. It has survived not only five centuries,Contrary to popular belief, Lorem Ipsum is not" +
    " simply random text. It has roots in a piece of classical Latin literature from 45 BC, ctions 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
