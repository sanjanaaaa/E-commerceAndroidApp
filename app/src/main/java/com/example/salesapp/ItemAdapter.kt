package com.example.salesapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(var context:Context, var list:ArrayList<Item>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v:View=LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return ItemHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(list[position].name,list[position].price,list[position].photo,list[position].id)
    }

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(n:String,p:Double,u:String,item_id:Int)
        {
            itemView.item_name.text=n
            itemView.item_price.text="₹"+p.toString()+"/Unit"
            Picasso.with(itemView.context).load("http://192.168.1.12/SalesWeb/images/"+u).into(itemView.item_photo)

            itemView.item_add_photo.setOnClickListener {
                UserInfo.itemId=item_id

                var obj=QtyFragment()
                var manager=(itemView.context as Activity).fragmentManager
                obj.show(manager,"Qty")
            }
        }
    }
}