package com.example.dicetest.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import com.example.dicetest.BR
import com.example.dicetest.R
import com.example.dicetest.data.repos.model.IncidentModel
import com.example.dicetest.databinding.IncidentItemBinding

class MyIncidentModelRecyclerViewAdapter(
    private val viewmodel: IncidentFragmentViewModel
) : RecyclerView.Adapter<MyIncidentModelRecyclerViewAdapter.ViewHolder>() {

    var incedList: List<IncidentModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = IncidentItemBinding.inflate(inflater, parent, false)
        return ViewHolder(dataBinding, viewmodel)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setup(incedList[position], position)
    }

    override fun getItemCount(): Int = incedList.size

    fun updateIncedList(incedList: List<IncidentModel>) {
        this.incedList = incedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: IncidentItemBinding, private val viewmodel: IncidentFragmentViewModel)
        : RecyclerView.ViewHolder(binding.root) {

        fun setup(itemData: IncidentModel, pos: Int) {
            binding.setVariable(BR.itemData, itemData)
            val bundle = bundleOf("incident_id" to pos)
            binding.incidentCard.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_incidentModelFragment_to_incidentDetailFragemnt, bundle))
            binding.executePendingBindings()
        }
    }
}