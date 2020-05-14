package com.example.uebungrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView;
    lateinit var mAdapter : ListAdapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: LinkedList<String> = LinkedList()
        val rnd = Random()
        for (i in 0..49) items.add(
            ('A' + rnd.nextInt('Z' - 'A')).toString() + " " +
                    Integer.toString(i)
        )
        items.sort()

        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview);
        mAdapter = ListAdapter(this, items);
        mRecyclerView.setAdapter(mAdapter)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))

    }
}
