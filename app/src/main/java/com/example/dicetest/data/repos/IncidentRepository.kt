package com.example.dicetest.data.repos

import com.example.dicetest.data.repos.model.IncidentModel
import com.example.dicetest.data.repos.resource.IncidentLocalGetter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IncidentRepository() {


    private val incidentLocalGetter = IncidentLocalGetter()
    lateinit var incidents:List<IncidentModel>

    init {
        CoroutineScope(Dispatchers.IO).launch { incidents = getIncidentList() }

    }

    fun getIncidentList(): List<IncidentModel> {
        val incidentList: List<IncidentModel> = incidentLocalGetter.getIncidents();
        return incidentList
    }

    companion object {
        private var INSTANCE: IncidentRepository? = null
        fun getInstance() = INSTANCE
            ?: IncidentRepository().also {
                INSTANCE = it
            }
        fun initialize() {
            INSTANCE = IncidentRepository()
        }
    }
}