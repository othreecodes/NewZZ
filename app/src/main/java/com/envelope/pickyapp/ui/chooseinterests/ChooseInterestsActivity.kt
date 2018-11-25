package com.envelope.pickyapp.ui.chooseinterests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envelope.pickyapp.R

class ChooseInterestsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_interests_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ChooseInterestsFragment.newInstance())
                .commitNow()
        }
    }

}
