package com.example.project

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_borrow_list.view.*

class BorrowlistAdapter(val context: Context,
                         val items : ArrayList<Borrowlist_data>
) : RecyclerView.Adapter<BorrowlistHolder>()
{
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BorrowlistHolder {
        //var mView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return BorrowlistHolder(LayoutInflater.from(context).inflate(R.layout.item_main_borrowlist, parent, false))
    }

    override fun onBindViewHolder(p0: BorrowlistHolder, p1: Int) {
        p0.br_no .text = items[p1].br_no
        p0.ps_name .text = items[p1].ps_fname+" "+items[p1].ps_lname
        p0.br_date .text = items[p1].br_date.take(10)+"  ถึง "
        p0.br_check_date .text = items[p1].br_check_date.take(10)
        p0.brst_name .text = items[p1].brst_name

    }
}

class BorrowlistHolder (view: View) : RecyclerView.ViewHolder(view) {
    val br_no = view.textView7
    val ps_name = view.textView9
    val br_check_date = view.textView5
    val br_date = view.textView4
    val brst_name = view.textView12

}



