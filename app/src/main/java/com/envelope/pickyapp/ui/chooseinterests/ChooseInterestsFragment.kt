package com.envelope.pickyapp.ui.chooseinterests

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.Interest
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.*
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.choose_interests_fragment.*
import java.util.*


class ChooseInterestsFragment : Fragment() {

    companion object {
        fun newInstance() = ChooseInterestsFragment()
    }

    private lateinit var viewModel: ChooseInterestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.choose_interests_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChooseInterestsViewModel::class.java)
        // TODO: Use the ViewModel

//        Fakein
        Fakeit.init()

        val ind = mutableListOf<Interest>(Interest("Food"),Interest("Football"),Interest("Sport"),Interest("Priemier League"),Interest("Sport"),Interest("Sport"))

        for(i in 1..20){
            ind.add(Interest(Fakeit.music().instrument()))
        }
        for(i in 1..10){
            ind.add(Interest(Fakeit.rockBand().name()))
        }

        for(i in 1..20){
            ind.add(Interest(Fakeit.artist().name()))
        }
        val sglm = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH

        layoutManager.flexWrap = FlexWrap.WRAP

        recyclerinterests.layoutManager = layoutManager

        recyclerinterests.adapter= ChooseInterestsAdapter(ind)

    }

}
