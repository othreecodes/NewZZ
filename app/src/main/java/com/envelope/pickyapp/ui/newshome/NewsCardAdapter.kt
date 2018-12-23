package com.envelope.pickyapp.ui.newshome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.envelope.pickyapp.GlideApp
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.NewsItem
import kotlinx.android.synthetic.main.content_news_card.*
import kotlinx.android.synthetic.main.content_news_card.view.*

class NewsCardAdapter(var newsItems:List<NewsItem>): RecyclerView.Adapter<NewsCardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_news_card,parent,false))

    }

    override fun getItemCount()= newsItems.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.itemView.image
        val item = newsItems[position]
        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 20f
        circularProgressDrawable.start()
        GlideApp.with(holder.itemView.context).load(item.mediaUrl).placeholder(circularProgressDrawable).into(holder.itemView.image)

        holder.itemView.image.scaleType = ImageView.ScaleType.FIT_XY


    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun unregisterAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        return
    }
}