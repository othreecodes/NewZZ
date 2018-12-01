package com.envelope.pickyapp.ui.newshome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.NewsItem

class NewsCardAdapter(val newsItems:List<NewsItem>): RecyclerView.Adapter<NewsCardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_news_card,parent,false))

    }

    override fun getItemCount()= newsItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}