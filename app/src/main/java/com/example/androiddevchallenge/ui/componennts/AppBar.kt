package com.example.androiddevchallenge.ui.componennts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R

@Composable
fun AppBar(
    topAppBarText: String,
    navController: NavHostController,
    showBackButton:Boolean = false
) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = if (!showBackButton) {
                    Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                } else {
                    Modifier
                }
            )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24,),
                        "back"
                    )
                }
            }
        },
    )
}