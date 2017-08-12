package com.applications.whazzup.sealinetestwork.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.applications.whazzup.sealinetestwork.R
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.DataClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.EventClass
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.Item
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.MoveClass
import java.text.SimpleDateFormat

class SecondActivity : AppCompatActivity() {

    @BindView(R.id.second_const)
    lateinit var constLayout : ConstraintLayout

    @BindView(R.id.first_field_title_tv)
    lateinit  var firstFieldTitle : TextView

    @BindView(R.id.first_field_tv)
    lateinit  var firstFieldInfo : TextView

    @BindView(R.id.second_field_title_tv)
    lateinit  var secondFieldTitle : TextView

    @BindView(R.id.second_field_tv)
    lateinit  var secondFieldInfo : TextView

    @BindView(R.id.third_field_title_tv)
    lateinit  var thirdFieldTitle : TextView

    @BindView(R.id.third_field_tv)
    lateinit  var thirdFieldInfo : TextView

    @BindView(R.id.second_toolbar)
    lateinit  var toolBar : Toolbar

    lateinit var  actionBar : ActionBar

    val format : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ButterKnife.bind(this)
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
        setSupportActionBar(toolBar)
        actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun showMoveClass(i: MoveClass) {
        actionBar.title = i.javaClass.simpleName
        firstFieldTitle.text = "From place"
        firstFieldInfo.text = i.fromPlace
        secondFieldTitle.text = "To Place"
        secondFieldInfo.text = i.toPlace
        thirdFieldTitle.text = "Estimate time"
        thirdFieldInfo.text = i.estimateTime.toString()
    }

    private fun showEventClassInfo(i: EventClass) {
        actionBar.title = i.javaClass.simpleName
        firstFieldTitle.text = "Start time"
        firstFieldInfo.text = format.format(i.startTime)
        secondFieldTitle.text = "End time"
        secondFieldInfo.text = format.format(i.endTime)
        thirdFieldTitle.text = "Name"
        thirdFieldInfo.text = i.name
    }

    private fun showDataClassInfo(i: DataClass) {
        actionBar.title = i.javaClass.simpleName
        firstFieldTitle.text = "Fligth date"
        firstFieldInfo.text = format.format(i.flightDate)
        secondFieldTitle.text = "Gate"
        secondFieldInfo.text = i.gate
        thirdFieldInfo.visibility = View.GONE
        thirdFieldTitle.visibility = View.GONE
    }



}
