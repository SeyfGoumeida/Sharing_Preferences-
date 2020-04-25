package com.example.tdm2tp1exo1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ChooseColorActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_color)
        title = "KotlinApp"
        textView = findViewById(R.id.textView)
        spinner = findViewById(R.id.colorspinner)
        layout = findViewById(R.id.layout)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.colors,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        if(getColor()!=ContextCompat.getColor(this, R.color.colorPrimary))
        {
            layout.setBackgroundColor(getColor())
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {

            R.id.activity2 -> {
                val intent2 = Intent(this@ChooseColorActivity,Main2Activity::class.java)
                intent2.putExtra("MyPreferedColor",getColor())
                startActivity(intent2)
                return true
            }
            R.id.activity3 -> {
                val intent3 = Intent(this@ChooseColorActivity,Main3Activity::class.java)
                intent3.putExtra("MyPreferedColor",getColor())
                startActivity(intent3)

                return true
            }

            R.id.activity1 -> {
                val intent1 = Intent(this@ChooseColorActivity,MainActivity::class.java)
                intent1.putExtra("MyPreferedColor",getColor())
                startActivity(intent1)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()

        textView.text = text

        if (position==0) {
            //Nothing to do
        }
        if (position==1) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.White))
            setColor(ContextCompat.getColor(this, R.color.White))
        }
        if (position==2) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.Dark))
            setColor(ContextCompat.getColor(this, R.color.Dark))
        }
        if (position==3) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.Green))
            setColor(ContextCompat.getColor(this, R.color.Green))

        }
        if (position==4) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.Pink))
            setColor(ContextCompat.getColor(this, R.color.Pink))

        }

    }
    fun setColor( colorid:Int) {
        val sharedPref: SharedPreferences = getSharedPreferences("MyPreferedColor", Context.MODE_PRIVATE)
        val sharedPrefEdit = sharedPref.edit()
        sharedPrefEdit.putInt("color",colorid)
        sharedPrefEdit.apply()
    }
    fun getColor() :Int {
        val sharedPref: SharedPreferences = getSharedPreferences("MyPreferedColor", Context.MODE_PRIVATE)
        return sharedPref.getInt("color", ContextCompat.getColor(this, R.color.colorPrimary))
    }



}


    //-------------spinner selection------------


