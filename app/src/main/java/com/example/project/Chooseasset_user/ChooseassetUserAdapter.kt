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
import kotlinx.android.synthetic.main.item_chooseasset_user.view.*
import kotlinx.android.synthetic.main.item_main_borrowlist.view.*

class ChooseassetUserAdapter(val context: Context,
                     val items : ArrayList<Chooseasset_user_data>
) : RecyclerView.Adapter<ChooseassetUserHolder>()
{
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseassetUserHolder {
        var mView = LayoutInflater.from(context).inflate(R.layout.item_chooseasset_user, parent, false)
        //var btn_detail = mView.btndetail
        var mViewHolder = ChooseassetUserHolder(mView)
        //btn_detail.setOnClickListener {

           // var selectItem = mViewHolder.layoutPosition
//            var intent_Detail = Intent(context, Detail::class.java)
//            intent_Detail.putExtra("br_no", items[selectItem].br_no)
//            intent_Detail.putExtra("ps_fname", items[selectItem].ps_fname)
//            intent_Detail.putExtra("ps_lname", items[selectItem].ps_lname)
//            intent_Detail.putExtra("br_date", items[selectItem].br_date)
//            intent_Detail.putExtra("br_check_date", items[selectItem].br_check_date)
//            intent_Detail.putExtra("eqs_code_old", items[selectItem].eqs_code_old)
//            intent_Detail.putExtra("eqs_name", items[selectItem].eqs_name)
//            intent_Detail.putExtra("brst_name", items[selectItem].brst_name)

            //context.startActivity(intent_Detail)
        //}
        return mViewHolder
    }

    override fun onBindViewHolder(p0: ChooseassetUserHolder, p1: Int) {
        p0.name .text = items[p1].eqs_name
        p0.code_old .text = items[p1].eqs_code_old

//        p0.ps_name .text = items[p1].ps_fname+" "+items[p1].ps_lname
//        p0.br_date .text = items[p1].br_date.take(10)
//        p0.checkdate .text = items[p1].br_check_date.take(10)
//        p0.brst_name .text = items[p1].brst_name


    }
}

class ChooseassetUserHolder (view: View) : RecyclerView.ViewHolder(view) {
    val name = view.valuename1
    val code_old = view.valuenumber1

}