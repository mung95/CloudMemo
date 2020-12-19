package com.example.cloudmemo

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import android.widget.TextClock
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.size
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    val dateTime: LocalDateTime = LocalDateTime.now()
    var MemoList = arrayListOf<Struct_Memo>(
        Struct_Memo("Title","Test Memo", "mcJo", dateTime.toString())
    )
    var myAdapter = MyAdapter(this,MemoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_count.setText(myAdapter.count.toString() + "개의 메모")

        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("message")

        lv_Main.adapter = myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_main, menu)

       return true
    }


    fun onClick(view: View) {
        val intent = Intent(this@MainActivity, CreateMemo::class.java)
        startActivity(intent)
    }

    fun onClick_Serach(item: MenuItem) {
        val intent = Intent(this@MainActivity, Search::class.java)
        startActivityForResult(intent,1)
    }



}
