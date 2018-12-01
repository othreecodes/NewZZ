package com.envelope.pickyapp.ui.newshome

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.envelope.pickyapp.R

class LiveNewsFragment : Fragment() {

    companion object {
        fun newInstance() = LiveNewsFragment()
    }

    private lateinit var viewModel: LiveNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.live_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LiveNewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
