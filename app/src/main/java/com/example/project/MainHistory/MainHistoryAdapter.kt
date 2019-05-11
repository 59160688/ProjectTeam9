package com.example.project

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.item_borrow_list.view.*

class MainHistoryAdapter(val context: Context,
                     val items : ArrayList<MainHis>
) : RecyclerView.Adapter<HisHolder>()
{
    // Gets the number of animals in the list
    private var btndetail: Button? = null
    override fun getItemCount(): Int {
        return items.size
    }
    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HisHolder {
        var mView = LayoutInflater.from(context).inflate(R.layout.item_main_his, parent, false)
        var btn = mView.btndetail
        var mViewHolder = HisHolder(mView)
        btn.setOnClickListener {
            //var text = "Click Item " + dataSource[mViewHolder.layoutPosition].title_name
            //Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
           //val recipeList = Recipe.getRecipesFromFile("books.json", context)
            var selectItem = mViewHolder.layoutPosition
            //   Toast.makeText(context,selectItem.title,Toast.LENGTH_SHORT).show()
            var intent_Detail =  Intent(context,Detail::class.java)
            intent_Detail.putExtra("br_no",items[selectItem].br_no)
            intent_Detail.putExtra("ps_fname",items[selectItem].ps_fname)
            intent_Detail.putExtra("ps_lname",items[selectItem].ps_lname)
            intent_Detail.putExtra("br_date",items[selectItem].br_date)
            intent_Detail.putExtra("br_check_date",items[selectItem].br_check_date)
            intent_Detail.putExtra("eqs_code_old",items[selectItem].eqs_code_old)
            intent_Detail.putExtra("eqs_name",items[selectItem].eqs_name)
            intent_Detail.putExtra("brst_name",items[selectItem].brst_name)

            context.startActivity(intent_Detail)
        }
        return mViewHolder//HisHolder(LayoutInflater.from(context).inflate(R.layout.item_main_his, parent, false))
    }

    override fun onBindViewHolder(p0: HisHolder, p1: Int) {
        p0.br_no .text = items[p1].br_no
        p0.ps_name .text = items[p1].ps_fname+" "+items[p1].ps_lname
        p0.br_date .text = items[p1].br_date.take(10)+"  ถึง "
        p0.br_check_date .text = items[p1].br_check_date.take(10)
        p0.brst_name .text = items[p1].brst_name

    }

}

class HisHolder (view: View) : RecyclerView.ViewHolder(view) {
    val br_no = view.textView7
    val ps_name = view.textView9
    val br_check_date = view.textView5
    val br_date = view.textView4
    val brst_name = view.textView12
    // val btndetail = view.btndetail

}



