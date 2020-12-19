package com.example.cloudmemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(val context: Context, val MemoList: ArrayList<Struct_Memo>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_lv_item, null)

        val tvTitle = view.findViewById<TextView>(R.id.tv_Title)
        val tvUserName = view.findViewById<TextView>(R.id.tv_UserName)
        val tvDate = view.findViewById<TextView>(R.id.tv_Date)
        val tvMemoText = view.findViewById<TextView>(R.id.tv_MemoText)

        val Memo = MemoList[position]

        tvTitle.text = Memo.Title
        tvUserName.text = Memo.UserName
        tvDate.text = Memo.Date
        tvMemoText.text = Memo.MemoText

        return view
    }

    override fun getItem(position: Int): Any {
        return MemoList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return MemoList.count()
    }

}