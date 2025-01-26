package com.thouma.concepts.menu.todoApp

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thouma.concepts.R

// Esta clase se encarga de manejar la vista de cada elemento de la lista de categorías
class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.categoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.cvCategoryContainer)

    fun  render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

        val color = if(taskCategory.isSelected){
            R.color.todo_background_todo_app
        }else{
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.todo_other_category))}
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.todo_personal_category))
            }
        }
    }
}