package com.example.groceryapp

import android.view.LayoutInflater
import android.widget.ImageView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val itemList:ArrayList<ItemModel>)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder( itemView: View)
        :RecyclerView.ViewHolder(itemView) {

        var itemImg: ImageView
        var itemTitle: TextView
        var itemDesc: TextView

        init {
            itemImg = itemView.findViewById(R.id.imageview)
            itemTitle = itemView.findViewById(R.id.title_txt)
            itemDesc = itemView.findViewById(R.id.description_text)
            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,"You Clicked :${itemList[adapterPosition].name}",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //called when RV need a new Viewholder Instance
        //inflating the ;ayout for single item and returnning a new VH
        val v =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent,false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //bind data to viewholder at a specific position
        holder.itemTitle.text = itemList[position].name
        holder.itemDesc.text = itemList[position].desc
        holder.itemImg.setImageResource(itemList[position].img)
    }
}