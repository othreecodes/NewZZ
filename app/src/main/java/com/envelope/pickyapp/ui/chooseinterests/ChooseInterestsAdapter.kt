package com.envelope.pickyapp.ui.chooseinterests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.Interest
import kotlinx.android.synthetic.main.content_interest_list.view.*

class ChooseInterestsAdapter(val interests:List<Interest>): RecyclerView.Adapter<ChooseInterestsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_interest_list,parent,false))
    }

    override fun getItemCount() = interests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.interest_name.text = interests[position].name

      }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}