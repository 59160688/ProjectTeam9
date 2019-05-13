package com.example.project

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.*
import kotlinx.android.synthetic.main.item_borrow_list.view.*
import kotlinx.android.synthetic.main.activity_chooseasset_user.view.*
import kotlinx.android.synthetic.main.item_main_borrowlist.view.*


class ChooseformatUserAdapter(val context: Context,
                              val items : ArrayList<Chooseformat_user_data>
) : RecyclerView.Adapter<ChooseformatUserHolder>()
{
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ChooseformatUserHolder {
        
        var mView = LayoutInflater.from(context).inflate(R.layout.activity_chooseformat_user, parent, false)
        var btn_return = mView.btnreturn
        var mViewHolder = ChooseformatUserHolder(mView)
//        btn_return.setOnClickListener {
//
//            var selectItem = mViewHolder.layoutPosition
//            var intent_Return = Intent(context, Return::class.java)
//            intent_Return.putExtra("fmst_name", items[selectItem].fmst_name)
//
//
//            context.startActivity(intent_Return)
//        }
        return mViewHolder
    }

    override fun onBindViewHolder(p0: ChooseformatUserHolder, p1: Int) {
        p0.fmst_name .text = items[p1].fmst_name
    }
}

class ChooseformatUserHolder (view: View) : RecyclerView.ViewHolder(view) {
    val fmst_name = view.valuenumber1

}
