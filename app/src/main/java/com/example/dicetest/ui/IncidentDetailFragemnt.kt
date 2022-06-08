package com.example.dicetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.dicetest.R
import com.example.dicetest.data.repos.model.IncidentModel
import com.example.dicetest.databinding.FragmentIncidentDetailFragemntBinding
import com.example.dicetest.BR
import com.example.dicetest.databinding.FragmentItemListBinding


class IncidentDetailFragemnt : Fragment() {

    private lateinit var dataBinding: FragmentIncidentDetailFragemntBinding
    private var incId: Int? = -1;
    private lateinit var itemData: IncidentModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        incId = arguments?.getInt("incident_id")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = FragmentIncidentDetailFragemntBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProvider(this@IncidentDetailFragemnt).get(IncidentFragmentViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        // Inflate the layout for this fragment
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewmodel?.getData()
        dataBinding.viewmodel?.incidentList?.value?.apply{
            if (incId != null){
                itemData = this[incId!!]
                dataBinding.setVariable(BR.itemData, itemData)
                dataBinding.executePendingBindings()
            }
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */

        @JvmStatic
        fun newInstance() =
            IncidentDetailFragemnt()

    }
}