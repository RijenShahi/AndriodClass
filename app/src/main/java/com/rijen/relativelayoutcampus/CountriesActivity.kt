package com.rijen.relativelayoutcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountriesActivity : AppCompatActivity() {

    private lateinit var lvCountry : ListView
    private val country = arrayOf(
        "Nepal","Kathmandu",
        "India", "New  Delhi",
        "China", "Beijing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        lvCountry = findViewById(R.id.lvCountry)

        val countryCapitalMap = mutableMapOf<String, String>()

        //put all the arry's element in Map
        for (i in country.indices step 2){
            countryCapitalMap[country[i]] = country[i+1]
        }

        //Adapter
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            countryCapitalMap.keys.toTypedArray()
        )
        lvCountry.adapter = adapter

        //on item click listner
        lvCountry.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, element, Toast.LENGTH_SHORT).show()
        }
    }
}