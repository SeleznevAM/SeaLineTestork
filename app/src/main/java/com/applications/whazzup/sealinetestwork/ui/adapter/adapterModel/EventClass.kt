package com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel

import android.os.Parcel
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


class EventClass(var startTime : Date, var endTime : Date, var name : String) : Item, Serializable {

    val format : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")

    override fun getInfoFromObject(): String {
        val buffer : StringBuffer = StringBuffer(this.javaClass.simpleName)
        buffer.append("\nstartTime: ")
        buffer.append(format.format(startTime))
        buffer.append("\nendTime: ")
        buffer.append(format.format(endTime))
        buffer.append("\nname: ")
        buffer.append(name)
        return buffer.toString()
    }

}