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
package com.example.androiddevchallenge.ui.componennts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.PuppyData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun PuppyDetailsScreen(
    id: Int,
    viewModel: PuppyViewModel,
    navController: NavHostController
) {

    val puppyData = viewModel.findPuppy(id)
    if (puppyData != null) {
        Scaffold(
            topBar = {
                AppBar(topAppBarText = puppyData.breed, navController, true)
            }
        ) {
            PuppyDetails(puppyDetails = puppyData)
        }
    }
}

@Composable
fun PuppyDetails(puppyDetails: PuppyData) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = puppyDetails.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(256.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = puppyDetails.name, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppyDetails.breed, style = MaterialTheme.typography.body1)
        Text(text = puppyDetails.gender, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppyDetails.description, style = MaterialTheme.typography.body2)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PreviewDetailsScreen() {
    MyTheme {
        PuppyDetailsScreen(1, PuppyViewModel(), rememberNavController())
    }
}
