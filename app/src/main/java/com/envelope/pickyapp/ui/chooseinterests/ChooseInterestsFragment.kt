package com.envelope.pickyapp.ui.chooseinterests

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.Interest
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.andrognito.flashbar.Flashbar
import com.envelope.pickyapp.ui.newshome.NewsHomeActivity
import com.envelope.pickyapp.ui.registeremail.RegisterEmailActivity
import com.google.android.flexbox.*
import com.google.gson.Gson
import com.mooveit.library.Fakeit
import es.dmoral.prefs.Prefs
import kotlinx.android.synthetic.main.choose_interests_fragment.*


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

        viewModel.allInterests.value = ind
        val layoutManager = FlexboxLayoutManager(context)

        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH

        layoutManager.flexWrap = FlexWrap.WRAP

        recyclerinterests.layoutManager = layoutManager

        recyclerinterests.adapter = ChooseInterestsAdapter(viewModel.allInterests.value!!,viewModel.chosenInterest)

        val builder=Flashbar.Builder(activity!!)
            .gravity(Flashbar.Gravity.BOTTOM)
            .primaryActionText("Continue")
            .primaryActionTextSizeInSp(20f)
            .messageSizeInSp(20f)
            .backgroundColor(resources.getColor(R.color.colorPrimary))
            .message("You're all set !")
            .primaryActionTapListener(object :Flashbar.OnActionTapListener{
                override fun onActionTapped(bar: Flashbar) {
                    Prefs.with(context!!).write("interests", Gson().toJson(viewModel.chosenInterest.value))
                    startActivity(Intent(activity, NewsHomeActivity::class.java))
                    activity!!.finish()


                }

            })
            .build()

        viewModel.chosenInterest.observe(this,androidx.lifecycle.Observer { it ->

            val size =  it.size
            if (size in 1..9){
                if(builder.isShowing()){
                    builder.dismiss()
                }

                Toast.makeText(context,"Select ${10-size} more to continue",Toast.LENGTH_SHORT).show()
            }else if(it.size>=10){

                    if(!builder.isShowing()) {
                        builder.show()
                    }
            }

        })



        filtertext.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {


            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (recyclerinterests.adapter as ChooseInterestsAdapter).interests = viewModel.allInterests.value!!.filter {
                    it.name.toLowerCase().contains(s!!)
                }.toMutableList()
                (recyclerinterests.adapter as ChooseInterestsAdapter).notifyDataSetChanged()
            }

        })

    }

}
