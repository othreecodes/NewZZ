package com.envelope.pickyapp.ui.registeremail

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.envelope.pickyapp.R
import com.envelope.pickyapp.ui.chooseinterests.ChooseInterestsActivity
import com.google.gson.Gson
import es.dmoral.prefs.Prefs
import kotlinx.android.synthetic.main.register_email_fragment.*


class RegisterEmailFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = RegisterEmailFragment()
    }

    private lateinit var viewModel: RegisterEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.register_email_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterEmailViewModel::class.java)

        continue_button.setOnClickListener {

            if (email_text.text.isNullOrBlank()){
                email_text.setError("Please fill in this field")
                return@setOnClickListener
            }
                continue_button.isEnabled = false
            continue_button.setText("Please wait...")
                Toast.makeText(context,"Email Verification sent, Email confirmed",Toast.LENGTH_LONG).show().apply {

                    startActivity(Intent(activity,ChooseInterestsActivity::class.java))
                }




//            val fragment = VerifyEmailFragment.newInstance()
//            val fragmentManager = activity!!.supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.setCustomAnimations(R.animator.fade_in,R.animator.fade_out)
//            fragmentTransaction.replace(R.id.root, fragment)
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
        }

    }

}
