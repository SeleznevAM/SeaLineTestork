package com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel

import java.io.Serializable


class MoveClass(var fromPlace: String,  var toPlace: String,  var estimateTime: Double) : Item, Serializable {

    override fun getInfoFromObject(): String {
        val buffer : StringBuffer = StringBuffer(this.javaClass.simpleName)
        buffer.append("\nfromPLace: ")
        buffer.append(fromPlace)
        buffer.append("\ntoPlace: ")
        buffer.append(toPlace)
        buffer.append("\nestimateTime")
        buffer.append(estimateTime)
        return buffer.toString()
    }
}