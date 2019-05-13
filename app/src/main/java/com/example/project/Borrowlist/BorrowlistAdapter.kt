package com.example.project

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_borrow_list.view.*
import kotlinx.android.synthetic.main.item_borrow_list.view.textView12
import kotlinx.android.synthetic.main.item_borrow_list.view.textView4
import kotlinx.android.synthetic.main.item_borrow_list.view.textView7
import kotlinx.android.synthetic.main.item_borrow_list.view.textView9
import kotlinx.android.synthetic.main.item_main_borrowlist.view.*

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
        var mView = LayoutInflater.from(context).inflate(R.layout.item_main_borrowlist, parent, false)
        var btn_return = mView.btnreturn
        var btn_approve = mView.btnapprove
        var btn_detail = mView.btn_detail
        var mViewHolder = BorrowlistHolder(mView)
        btn_return.setOnClickListener {

            var selectItem = mViewHolder.layoutPosition
            var intent_Return = Intent(context, Return::class.java)
            intent_Return.putExtra("br_no", items[selectItem].br_no)
            intent_Return.putExtra("ps_fname", items[selectItem].ps_fname)
            intent_Return.putExtra("ps_lname", items[selectItem].ps_lname)
            intent_Return.putExtra("br_date", items[selectItem].br_date)
            intent_Return.putExtra("br_check_date", items[selectItem].br_check_date)
            intent_Return.putExtra("eqs_code_old", items[selectItem].eqs_code_old)
            intent_Return.putExtra("eqs_name", items[selectItem].eqs_name)
            intent_Return.putExtra("brst_name", items[selectItem].brst_name)

            context.startActivity(intent_Return)
        }
        btn_approve.setOnClickListener {

            var selectItem = mViewHolder.layoutPosition
            var intent_Approve = Intent(context, Approve::class.java)
            intent_Approve.putExtra("br_no", items[selectItem].br_no)
            intent_Approve.putExtra("ps_fname", items[selectItem].ps_fname)
            intent_Approve.putExtra("ps_lname", items[selectItem].ps_lname)
            intent_Approve.putExtra("br_date", items[selectItem].br_date)
            intent_Approve.putExtra("br_check_date", items[selectItem].br_check_date)
            intent_Approve.putExtra("eqs_code_old", items[selectItem].eqs_code_old)
            intent_Approve.putExtra("eqs_name", items[selectItem].eqs_name)
            intent_Approve.putExtra("brst_name", items[selectItem].brst_name)

            context.startActivity(intent_Approve)
        }
        btn_detail.setOnClickListener {

            var selectItem = mViewHolder.layoutPosition
            var intent_Detail = Intent(context, Detail::class.java)
            intent_Detail.putExtra("br_no", items[selectItem].br_no)
            intent_Detail.putExtra("ps_fname", items[selectItem].ps_fname)
            intent_Detail.putExtra("ps_lname", items[selectItem].ps_lname)
            intent_Detail.putExtra("br_date", items[selectItem].br_date)
            intent_Detail.putExtra("br_check_date", items[selectItem].br_check_date)
            intent_Detail.putExtra("eqs_code_old", items[selectItem].eqs_code_old)
            intent_Detail.putExtra("eqs_name", items[selectItem].eqs_name)
            intent_Detail.putExtra("brst_name", items[selectItem].brst_name)

            context.startActivity(intent_Detail)
        }
        return mViewHolder
    }

    override fun onBindViewHolder(p0: BorrowlistHolder, p1: Int) {
        p0.br_no .text = items[p1].br_no
        p0.ps_name .text = items[p1].ps_fname+" "+items[p1].ps_lname
        p0.br_date .text = items[p1].br_date.take(10)
        p0.checkdate .text = items[p1].br_check_date.take(10)
        p0.brst_name .text = items[p1].brst_name

    }
}

class BorrowlistHolder (view: View) : RecyclerView.ViewHolder(view) {
    val br_no = view.textView7
    val ps_name = view.textView9
    val br_date = view.textView4
    val brst_name = view.textView12
    val checkdate = view.checkdat

 }



