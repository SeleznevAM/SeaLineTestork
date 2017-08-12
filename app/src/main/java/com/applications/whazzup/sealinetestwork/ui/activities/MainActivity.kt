package com.applications.whazzup.sealinetestwork.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.applications.whazzup.sealinetestwork.R

import butterknife.BindView
import butterknife.ButterKnife
import com.applications.whazzup.sealinetestwork.ui.adapter.TypeAdapter
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.DataClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.EventClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.MoveClass
import java.util.*


class MainActivity : AppCompatActivity() {

    @BindView(R.id.main_recycler) lateinit var recycler : RecyclerView
    @BindView(R.id.main_toolbar) lateinit var toolBar : Toolbar
    lateinit var actionBar : ActionBar

    var recyclerAdapter : TypeAdapter = TypeAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        mockData()
        initToolBar()
        val intent : Intent = Intent(this, SecondActivity :: class.java)
        with(recycler){
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this.context)
            (adapter as TypeAdapter).addListener {
                intent.putExtra("ITEM_KEY",(adapter as TypeAdapter).getItemByPosition(it))
                startActivity(intent) }
        }
    }

    private fun initToolBar() {
        setSupportActionBar(toolBar)
        actionBar = supportActionBar!!
        actionBar.title = "SeaLine Test work"
    }

    private fun mockData() {
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(50000000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(60000000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
        recyclerAdapter.addItem(DataClass(Date(5000000L), "1234"))
        recyclerAdapter.addItem(EventClass(Date(6000000L), Date(7000000L), "MyEvent"))
        recyclerAdapter.addItem(MoveClass("Moscow", "Parish", 1.1))
    }
}