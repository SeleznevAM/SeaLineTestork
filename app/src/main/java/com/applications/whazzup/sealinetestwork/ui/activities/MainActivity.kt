package com.applications.whazzup.sealinetestwork.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import com.applications.whazzup.sealinetestwork.R
import com.applications.whazzup.sealinetestwork.ui.adapter.TypeAdapter
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.DataClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.EventClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.MoveClass
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    lateinit private var actionBar : ActionBar

    lateinit private var recyclerAdapter : TypeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolBar()

        val intent : Intent = Intent(this, SecondActivity :: class.java)
        with(main_recycler){
            recyclerAdapter = TypeAdapter {
                item ->  intent.putExtra("ITEM_KEY", item)
                startActivity(intent)}
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
        mockData()
    }

    private fun initToolBar() {
        setSupportActionBar(main_toolbar)
        actionBar = supportActionBar!!
        actionBar.title = "SeaLine Test work"
    }

    private fun mockData() {

        val min = 10
        val max = 100
        var result = min + ((Math.random()*(max - min)+1).toInt())
        println(result)

        for(i : Int in 1..result){
            if(i%2==0){
                recyclerAdapter.addItem(DataClass(Date(i*10000000L), "Выход №"+i))
            }else
            if(i%3==0){
                recyclerAdapter.addItem(EventClass(Date(i*20000000L),Date(), "Задача №"+i))
            }else {
                recyclerAdapter.addItem(MoveClass("Место №" + i, "Место №" + i + 1, i + 0.14))
            }
        }
    }
}