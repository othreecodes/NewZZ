package com.envelope.pickyapp


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.envelope.pickyapp.data.dao.NewsItemDao
import com.envelope.pickyapp.data.dto.NewsItem

@Database(entities = arrayOf(NewsItem::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsItemDao(): NewsItemDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        internal fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room
                            .databaseBuilder(
                                context.getApplicationContext(),
                                AppDatabase::class.java, "database"
                            )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}

