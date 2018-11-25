package com.envelope.pickyapp.ui.chooseinterests

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.envelope.pickyapp.data.dto.Interest

class ChooseInterestsViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val allInterests:MutableLiveData<MutableList<Interest>> = MutableLiveData()
    val chosenInterest:MutableLiveData<MutableList<String>> = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
}
