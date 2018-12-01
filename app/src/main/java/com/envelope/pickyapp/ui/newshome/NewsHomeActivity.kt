package com.envelope.pickyapp.ui.newshome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envelope.pickyapp.R
import kotlinx.android.synthetic.main.news_home_activity.*

class NewsHomeActivity : AppCompatActivity() {

    lateinit var pagerAdapter:HomeViewpager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_home_activity)


        pagerAdapter = HomeViewpager(supportFragmentManager)
        container.adapter = pagerAdapter
        bnve.setupWithViewPager(container)



    }

}
