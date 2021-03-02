package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.models.PuppyData
import com.example.androiddevchallenge.repository.PuppiesRepository

class PuppyViewModel : ViewModel() {

    val puppiesList: LiveData<List<PuppyData>> = MutableLiveData(PuppiesRepository.puppiesList)

    fun findPuppy(id: Int) = puppiesList.value?.find { it.id == id }

}