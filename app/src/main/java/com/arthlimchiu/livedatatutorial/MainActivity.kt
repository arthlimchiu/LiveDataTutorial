package com.arthlimchiu.livedatatutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var count: TextView
    private lateinit var add: Button
    private lateinit var subtract: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        count = findViewById(R.id.count_txt)
        add = findViewById(R.id.add_btn)
        subtract = findViewById(R.id.subtract_btn)

        viewModel.count.observe(this, Observer { currentCount ->
            count.text = currentCount.toString()
        })
    }

    override fun onStart() {
        super.onStart()

        add.setOnClickListener { viewModel.add() }
        subtract.setOnClickListener { viewModel.subtract() }
    }
}