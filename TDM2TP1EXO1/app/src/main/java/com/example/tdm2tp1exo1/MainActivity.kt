package com.example.tdm2tp1exo1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.res.ResourcesCompat.getColor
import com.github.dhaval2404.colorpicker.adapter.ColorViewBinding.setBackgroundColor

class MainActivity : AppCompatActivity() {
    lateinit var layout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent
        val color = intent.getIntExtra("MyPreferedColor",getColor())
        layout = findViewById(R.id.layout)
        layout.setBackgroundColor(color)

        setColor(getColor())

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
                 val intent2 = Intent(this,Main2Activity::class.java)
                 intent2.putExtra("color", getColor())
                 startActivity(intent2)
                 return true
             }
             R.id.activity3 -> {
                 val intent3 = Intent(this,Main3Activity::class.java)
                 intent3.putExtra("color", getColor())
                 startActivity(intent3)

                 return true
             }

             R.id.activityChangeColor -> {
                 val intentChooseColor = Intent(this,ChooseColorActivity::class.java)
                 intentChooseColor.putExtra("color", getColor())
                 startActivity(intentChooseColor)
                 return true
             }
            else -> super.onOptionsItemSelected(item)
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
