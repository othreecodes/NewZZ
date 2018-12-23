package com.envelope.pickyapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.envelope.pickyapp.data.dto.NewsItem

@Dao
interface NewsItemDao {

    @Query("SELECT * FROM news_item")
    fun getAll(): LiveData<List<NewsItem>>

    @Query("SELECT * FROM news_item WHERE ID IN (:newsids)")
    fun loadAllByIds(newsids: IntArray): LiveData<List<NewsItem>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg newsItems: NewsItem)

    @Delete
    fun delete(newsItem: NewsItem)
}