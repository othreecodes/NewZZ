package com.envelope.pickyapp.data.dto

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_item")
data class NewsItem(@PrimaryKey @NonNull var ID:String="", var title:String, var excerpt:String, var mediaUrl:String, var site:String="")