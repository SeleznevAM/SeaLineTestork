package com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel
import java.io.Serializable


interface Item : Serializable {

    fun getInfoFromObject() : String
}