package com.envelope.pickyapp.ui.newshome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envelope.pickyapp.R

class NewsHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsHomeFragment.newInstance())
                .commitNow()
        }
    }

}
