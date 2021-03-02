package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.PuppyData

object PuppiesRepository {
    val puppiesList = listOf(
        PuppyData(
            1,
            "First Puppy",
            "Breed1",
            R.drawable.ic_launcher_background,
            "Male",
            "This is the description for first puppy"
        ), PuppyData(
            2,
            "Second puppy",
            "Breed2",
            R.drawable.ic_launcher_background,
            "Female",
            "This is the description for second puppy"
        )
    )
}