package com.envelope.pickyapp.ui.chooseinterests

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.envelope.pickyapp.data.dto.Interest

class ChooseInterestsViewModel(app:Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModel

    val allInterests:MutableLiveData<MutableList<Interest>> = MutableLiveData()
    val chosenInterest:MutableLiveData<MutableList<String>> = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }



    fun fetchInterests(){

    }
}
