package com.envelope.pickyapp.ui.registeremail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envelope.pickyapp.R
import com.envelope.pickyapp.ui.registeremail.RegisterEmailFragment

class RegisterEmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_email_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegisterEmailFragment.newInstance())
                .commitNow()
        }
    }

}
