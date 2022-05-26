package com.example.dicetest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicetest.data.repos.model.IncidentModel
import com.example.dicetest.data.repos.IncidentRepository

class IncidentFragmentViewModel: ViewModel() {

    val incidentList = MutableLiveData<List<IncidentModel>>()

    fun getData(){
        IncidentRepository.getInstance().getIncidentList().apply {
            incidentList.value = this
        }
    }
}