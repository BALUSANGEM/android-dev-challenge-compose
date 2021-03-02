package com.example.androiddevchallenge.ui.componennts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.AppBar
import com.example.androiddevchallenge.DETAILS_PAGE
import com.example.androiddevchallenge.models.PuppyData
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun PuppiesListScreen(viewModel: PuppyViewModel, navController: NavHostController) {
    val puppies = viewModel.puppiesList.observeAsState()
    puppies.value?.let { puppyList ->
        Scaffold(
            topBar = {
                AppBar(topAppBarText = "Adopt Puppy",navController)
            }
        ){
            PuppiesList(puppyList) {
                navController.navigate("${DETAILS_PAGE}/${it.id}")
            }
        }
    }
}

@Composable
fun PuppiesList(puppies: List<PuppyData>, onClick: (PuppyData) -> Unit) {
    LazyColumn{
        items(puppies.size) { index ->
            Card(
                modifier = Modifier.clickable {onClick(puppies[index])},
            ){
                PuppyListItem(puppyDetails = puppies[index])
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}