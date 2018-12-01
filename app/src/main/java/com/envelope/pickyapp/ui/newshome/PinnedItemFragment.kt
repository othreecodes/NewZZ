package com.envelope.pickyapp.ui.newshome

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.envelope.pickyapp.R

class PinnedItemFragment : Fragment() {

    companion object {
        fun newInstance() = PinnedItemFragment()
    }

    private lateinit var viewModel: PinnedItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pinned_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PinnedItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
