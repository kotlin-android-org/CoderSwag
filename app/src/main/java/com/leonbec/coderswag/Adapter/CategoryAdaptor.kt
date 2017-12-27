package com.leonbec.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.jonnyb.coderswag.Model.Category
import com.leonbec.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by leonbec on 2017/12/27.
 */
class CategoryAdaptor(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryAdaptor.VH>() {
    override fun onBindViewHolder(holder: VH?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)
        return VH(view)
    }

    inner class VH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
//        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
//        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)
        val categoryImage = itemView?.categoryImage
        val categoryName = itemView?.categoryName
        fun bindCategory(category: Category, context: Context) {
            val resId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resId)
            categoryName?.text = category.title
        }
    }
}