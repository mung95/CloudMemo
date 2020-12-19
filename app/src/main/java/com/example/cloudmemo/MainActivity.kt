package com.example.cloudmemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.size
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_count.setText(lv_Main.childCount.toString() + "개의 메모")

        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("message")


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