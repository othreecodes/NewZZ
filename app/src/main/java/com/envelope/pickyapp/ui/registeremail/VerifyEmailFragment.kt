package com.envelope.pickyapp.ui.registeremail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.envelope.pickyapp.R
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth

class VerifyEmailFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = VerifyEmailFragment()
    }

    private lateinit var viewModel: VerifyEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.verify_email_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VerifyEmailViewModel::class.java)

        val auth = FirebaseAuth.getInstance()


        auth.createUserWithEmailAndPassword("daviduchenna@outlook.com","daviduchenna@outlook.com").addOnCompleteListener {
            Log.e(it.toString(),"ssss")

            val actionCodeSettings = ActionCodeSettings.newBuilder()

            actionCodeSettings.setUrl("323223")

            it.result!!.user?.sendEmailVerification(actionCodeSettings.build())
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("mail", "Email sent.")
                    }else{
                        Log.d("mail", "Email not sent.${task.exception!!.message}")
                    }
                }

        }




    }

}
