package com.envelope.pickyapp.ui.chooseinterests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.Interest
import kotlinx.android.synthetic.main.content_interest_list.view.*
import java.lang.Exception

class ChooseInterestsAdapter(
    var interests: MutableList<Interest>,
    var chosenInterest: MutableLiveData<MutableList<String>>
): RecyclerView.Adapter<ChooseInterestsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_interest_list,parent,false))
    }

    override fun getItemCount() = interests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val interest = interests[position]
        val context = holder.itemView.context
        holder.itemView.interest_name.text = interest.name

        if(!interest.selected){

            holder.itemView.interest_name.background = context.resources.getDrawable(R.drawable.drawable_orange_box)
            holder.itemView.interest_name.setTextColor(context.resources.getColor(R.color.grey_40))


        }else{
             holder.itemView.interest_name.setBackgroundColor(context.resources.getColor(R.color.colorPrimary))
            holder.itemView.interest_name.setTextColor(context.resources.getColor(R.color.colorWhite))


        }


        holder.itemView.interest_name.setOnClickListener {

            if(interest.selected){
                interest.selected = false
                holder.itemView.interest_name.background = context.resources.getDrawable(R.drawable.drawable_orange_box)
                holder.itemView.interest_name.setTextColor(context.resources.getColor(R.color.grey_40))
                try {

                chosenInterest.value!!.remove(interest.name)
                    chosenInterest.postValue(chosenInterest.value)
                }
                catch (e:Exception){

                }

            }else{
                interest.selected = true
                holder.itemView.interest_name.setBackgroundColor(context.resources.getColor(R.color.colorPrimary))
                holder.itemView.interest_name.setTextColor(context.resources.getColor(R.color.colorWhite))
                chosenInterest.value!!.add(interest.name)
                chosenInterest.postValue(chosenInterest.value)

            }

        }


      }


    inner class ViewHolder( itemView: View):RecyclerView.ViewHolder(itemView)
}