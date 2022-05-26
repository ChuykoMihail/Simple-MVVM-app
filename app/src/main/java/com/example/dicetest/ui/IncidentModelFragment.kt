package com.example.dicetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.dicetest.data.repos.IncidentRepository
import com.example.dicetest.databinding.FragmentItemListBinding


/**
 * A fragment representing a list of Items.
 */
class IncidentModelFragment : Fragment() {


    private lateinit var dataBinding: FragmentItemListBinding
    private lateinit var adapter: MyIncidentModelRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentItemListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProvider(this@IncidentModelFragment).get(IncidentFragmentViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        IncidentRepository.initialize()
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.viewmodel?.getData()

        setupObservers()
        setupAdapter()
    }

    private fun setupObservers() {
        dataBinding.viewmodel?.incidentList?.observe(viewLifecycleOwner, Observer {
            adapter.updateIncedList(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = dataBinding.viewmodel
        if (viewModel != null) {
            adapter = MyIncidentModelRecyclerViewAdapter(dataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(context)
            dataBinding.incListRv.layoutManager = layoutManager
            dataBinding.incListRv.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
            dataBinding.incListRv.adapter = adapter
        }
    }
}