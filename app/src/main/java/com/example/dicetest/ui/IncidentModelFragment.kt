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



class IncidentModelFragment : Fragment() {


    private lateinit var dataBinding: FragmentItemListBinding
    private lateinit var adapter: MyIncidentModelRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    //датабайндинг+инициализация ресурсов
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //получить датабайндинг
        dataBinding = FragmentItemListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProvider(this@IncidentModelFragment).get(IncidentFragmentViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }

        //инициализация репозитория
        IncidentRepository.initialize()


        return dataBinding.root
    }

    //образ создан, подготовлен, можно запрашивать фоновую работу
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //получим данные.
        dataBinding.viewmodel?.getData()

        //привязать обозреватель к источнику данных
        setupObservers()

        //работа с адаптером для ListView
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
            //снаряжаем адаптеры
            adapter = MyIncidentModelRecyclerViewAdapter(dataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(context)
            dataBinding.incListRv.layoutManager = layoutManager
            dataBinding.incListRv.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
            dataBinding.incListRv.adapter = adapter
        }
    }
}