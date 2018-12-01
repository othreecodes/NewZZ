package com.envelope.pickyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envelope.pickyapp.ui.newshome.NewsHomeActivity
import com.envelope.pickyapp.ui.registeremail.RegisterEmailActivity
import es.dmoral.prefs.Prefs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!Prefs.with(this).contains("interests")) {
            startActivity(Intent(this, RegisterEmailActivity::class.java))
        }else{
            startActivity(Intent(this, NewsHomeActivity::class.java))
        }
        finish()
    }
}
