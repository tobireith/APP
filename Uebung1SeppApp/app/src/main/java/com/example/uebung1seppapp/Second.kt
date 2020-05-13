package com.example.uebung1seppapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var text = intent.getStringExtra("Param1");
        Log.d("Debugg1", text.toString());
        val textfeld = findViewById(R.id.second_text) as TextView;
        textfeld.setText(text);
    }
}
