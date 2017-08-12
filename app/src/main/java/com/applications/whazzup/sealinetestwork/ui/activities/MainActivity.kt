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
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №1"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Прогулка по городу"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(50000000000L), "Выход №2"))
        recyclerAdapter.addItem(EventClass(Date(60000000000L), Date(7000000L), "Поиграть в пейнбол"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Timbuktu", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №3"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Прогулка на велосипеде"))
        recyclerAdapter.addItem(MoveClass("Moscow", "USA", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №4"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "В поход"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Pekin", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №5"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Прыгнуть с парашютом"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Novgorod", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №6"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Сходить в театр"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Omsk", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №7"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Сплясать румбу"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Tomsk", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №8"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Рассказать анекдот"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Dusseldorf", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №9"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Покормить кота"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Obninsk", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №10"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Помыть машину"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Kaluga", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №11"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Сходить в барбершоп"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Rostov", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "Выход №12"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "Выспться"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Sochi", 1.1))
    }
}