package com.rijen.relativelayoutcampus

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class TimePickerActivity : AppCompatActivity() {

    private lateinit var tvTimePicker : TextView
    private lateinit var btnT : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        tvTimePicker = findViewById(R.id.tvTimePicker)
        btnT = findViewById(R.id.btnT)

        btnT.setOnClickListener {
            loadTime()
        }
    }

    private fun loadTime(){
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                tvTimePicker.text = "$hour:$minute"
            },hour,minute,false
        )
        timePickerDialog.show()
    }
}