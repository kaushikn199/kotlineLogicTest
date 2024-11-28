package com.example.kotlinelogictest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private var count : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val intent = intent;
        if (intent != null){
            count = intent.getIntExtra("data",0);
            Log.e("", "count : $count")
        }

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this,count)
        val data = ArrayList<ItemModel>()
        for (i in 1..count*count) {
            data.add(ItemModel(-1,-1))
        }
        val adapter = CustomAdapter(data,count)
        recyclerview.adapter = adapter


    }
}