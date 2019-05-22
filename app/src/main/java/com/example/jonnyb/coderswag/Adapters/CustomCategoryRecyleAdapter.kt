package com.example.jonnyb.coderswag.Adapters

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.jonnyb.coderswag.Model.Category
import com.example.jonnyb.coderswag.R

class CustomCategoryRecyleAdapter(val context: Context,val listCategory:List<Category>,val itemClick:(Category)->Unit)
    :RecyclerView.Adapter<CustomCategoryRecyleAdapter.ViewHoder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHoder {

        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)
       return ViewHoder(view )


    }

    override fun getItemCount(): Int {
       return listCategory.count()
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.bindView(listCategory.get(position))
    }


    inner class ViewHoder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindView( category: Category){
            val resourceId = context.resources.getIdentifier(category.image,
                    "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener {
                itemClick(category)
            }
        }

    }

}

