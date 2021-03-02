package com.example.androiddevchallenge.ui.componennts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.MyApp
import com.example.androiddevchallenge.models.PuppyData
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyListItem(
    modifier: Modifier = Modifier,
    puppyDetails: PuppyData,
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 16.dp,end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = puppyDetails.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

       Column(Modifier.fillMaxWidth()) {
           Text(text = puppyDetails.name, style= MaterialTheme.typography.h6)
           Text(text = puppyDetails.breed, style= MaterialTheme.typography.body1)
           Text(text = puppyDetails.gender, style= MaterialTheme.typography.body2)
       }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
