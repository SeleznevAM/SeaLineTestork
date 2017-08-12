package com.applications.whazzup.sealinetestwork.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import android.view.View
import com.applications.whazzup.sealinetestwork.R
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.DataClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.EventClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.Item
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.MoveClass
import kotlinx.android.synthetic.main.activity_second.*
import java.text.SimpleDateFormat

class SecondActivity : AppCompatActivity() {

    lateinit private var  actionBar : ActionBar

    val format : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initToolBar()
        var i :  Item = intent.getSerializableExtra("ITEM_KEY") as Item
        when(i){
            is DataClass ->  {showDataClassInfo(i)}
            is EventClass -> {showEventClassInfo(i)}
            is MoveClass -> { showMoveClass(i)}
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolBar() {
        setSupportActionBar(second_toolbar)
        actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun showMoveClass(i: MoveClass) {
        actionBar.title = i.javaClass.simpleName
        first_field_title_tv.text = "From place"
        first_field_tv.text = i.fromPlace
        second_field_tv.text = i.toPlace
        second_field_title_tv.text = "To Place"
        third_field_title_tv.text = "Estimate time"
        third_field_tv.text = i.estimateTime.toString()
    }

    private fun showEventClassInfo(i: EventClass) {
        actionBar.title = i.javaClass.simpleName
        first_field_title_tv.text = "Start time"
        first_field_tv.text = format.format(i.startTime)
        second_field_title_tv.text = "End time"
        second_field_tv.text = format.format(i.endTime)
        third_field_title_tv.text = "Name"
        third_field_tv.text = i.name
    }

    private fun showDataClassInfo(i: DataClass) {
        actionBar.title = i.javaClass.simpleName
        first_field_title_tv.text = "Fligth date"
        first_field_tv.text = format.format(i.flightDate)
        second_field_title_tv.text = "Gate"
        second_field_tv.text = i.gate
        third_field_tv.visibility = View.GONE
        third_field_title_tv.visibility = View.GONE
    }
}
