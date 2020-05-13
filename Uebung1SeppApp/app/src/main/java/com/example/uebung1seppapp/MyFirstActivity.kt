package com.example.uebung1seppapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_my_first.*

class MyFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_first)
        val myButton = findViewById(R.id.hello_world_button) as Button;
        myButton.setOnClickListener {
            Log.d("BTN_1", "The first button was pressed.")
            val myIntent = Intent(this, Second::class.java);

            var text = acivity_main_edit_text.text.toString();
            Log.d("Debugg2", text);
            myIntent.putExtra("Param1", text);
            startActivity(myIntent);
            };
    }
}