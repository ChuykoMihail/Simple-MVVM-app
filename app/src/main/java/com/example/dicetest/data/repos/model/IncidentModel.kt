package com.example.dicetest.data.repos.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*

data class IncidentModel(val STATUS: String,
                         val TICKETID: String,
                         val REPORTEDBY: String,
                         val CLASSIDMAIN: String,
                         val CRITIC_LEVEL: String,
                         val ISKNOWNERRORDATE: String,
                         val TARGETFINISH: String,
                         val DESCRIPTION: String,
                         val EXTSYSNAME: String,
                         val NORM: String,
                         val LNORM: String
)

//class IncidentDeserializer: JsonDeserializer<List<IncidentModel>> {
//    override fun deserialize(
//        json: JsonElement?,
//        typeOfT: Type?,
//        context: JsonDeserializationContext?
//    ): List<IncidentModel> {
//        json?.asJsonArray?.forEach {
//            it.asJsonObject["ISKNOWNERRORDATE"]
//        }
//    }
//
//}
