package com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel


import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


data class DataClass(var flightDate : Date, var gate: String)  : Item, Serializable{

    val format : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")

    override fun getInfoFromObject(): String {
        val buffer : StringBuffer = StringBuffer(this.javaClass.simpleName)
        buffer.append("\n flightDate: ")
        buffer.append(format.format(flightDate))
        buffer.append("\n gate: ")
        buffer.append(gate)
        return buffer.toString()
    }
}