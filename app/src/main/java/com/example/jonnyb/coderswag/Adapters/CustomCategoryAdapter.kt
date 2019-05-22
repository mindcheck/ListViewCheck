package com.example.jonnyb.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jonnyb.coderswag.Model.Category
import com.example.jonnyb.coderswag.R

class CustomCategoryAdapter(val context:Context,val listCategory: List<Category> ) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder
        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder();
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView?.tag = holder
        }else{
            categoryView = convertView;
           holder = categoryView.tag as ViewHolder
        }

        val resourceId = context.resources.getIdentifier(listCategory[position].image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = listCategory[position].title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return listCategory.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return listCategory.count()
    }

    class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}