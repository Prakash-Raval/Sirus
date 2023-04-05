package com.example.sirus.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sirus.R
import com.example.sirus.modals.CategoryData


class CategoriesAdapter(
    private val userList: ArrayList<CategoryData>
) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var catTitle: TextView = view.findViewById(R.id.categories_title)
        var catImage: ImageView = view.findViewById(R.id.categories_image)
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_card_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.catTitle.text = userList[position].title
        holder.catImage.setImageResource(userList[position].image)


    }

    override fun getItemCount(): Int {
        return userList.size
    }
}