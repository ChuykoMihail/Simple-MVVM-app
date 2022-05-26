package com.example.dicetest.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.dicetest.BR
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
        holder.setup(incedList[position])
    }

    override fun getItemCount(): Int = incedList.size

    fun updateIncedList(incedList: List<IncidentModel>) {
        this.incedList = incedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ViewDataBinding, private val viewmodel: IncidentFragmentViewModel)
        : RecyclerView.ViewHolder(binding.root) {

        fun setup(itemData: IncidentModel) {
            binding.setVariable(BR.itemData, itemData)
            binding.executePendingBindings()
    }




//        val sysName : TextView = binding.extSysName
//        val description: TextView = binding.description
//        val errorDate: TextView = binding.isKnownErrorDate
//        val finishDate: TextView = binding.targetFinish
//        val status: TextView = binding.status
    }

}