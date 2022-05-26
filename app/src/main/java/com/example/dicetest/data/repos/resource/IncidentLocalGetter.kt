package com.example.dicetest.data.repos.resource

import android.os.Environment
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dicetest.data.repos.model.IncidentModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class IncidentLocalGetter {

    private final val TAG = "IncidentLocalGetter"

    val gson = Gson();
    var incidents: MutableLiveData<List<IncidentModel>> = MutableLiveData<List<IncidentModel>>()
    fun getIncidents(): List<IncidentModel>{
        return try{
            val f: File = File(Environment.getExternalStorageDirectory().path, "incidents.json")
            val jsonString: String
            try {
                jsonString = f.bufferedReader().readText()
                convertIncidentFromJson(jsonString)
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                emptyList()
            }
        } catch (e: Exception){
            Log.d(TAG, e.toString())
            emptyList()
        }
    }

    private fun convertIncidentFromJson(str: String): List<IncidentModel> {
        val listIncidentType = object : TypeToken<List<IncidentModel>>() {}.type
        return gson.fromJson(str, listIncidentType)
    }

    private fun convertToJson(){
        //TODO save to local file
    }
}