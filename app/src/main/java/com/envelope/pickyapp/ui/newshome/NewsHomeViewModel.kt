package com.envelope.pickyapp.ui.newshome

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.envelope.pickyapp.AppDatabase
import com.envelope.pickyapp.data.dto.NewsItem

class NewsHomeViewModel(var app: Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModel
    lateinit var database:AppDatabase

    init {
        database = AppDatabase.getDatabase(app)!!
    }

    var newsItems: MutableLiveData<List<NewsItem>> = MutableLiveData<List<NewsItem>>().apply{

        postValue(database.newsItemDao().getAll().value)
    }

    fun getNews(){



    }

}
