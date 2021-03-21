package com.aprian1337.bfaa_codelab_intentexplicit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MoveWithData : AppCompatActivity(){
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    lateinit var tvDataReceived : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getStringExtra(EXTRA_AGE)
        val text = "Name : $name\nYour Age: $age"
        tvDataReceived = findViewById(R.id.tv_data_received)
        tvDataReceived.text = text
    }
}