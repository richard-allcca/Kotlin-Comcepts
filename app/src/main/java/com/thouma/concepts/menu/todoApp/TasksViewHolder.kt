package com.thouma.concepts.menu.todoApp

import android.content.res.ColorStateList
import android.view.View
import android.widget.CheckBox

import android.graphics.Paint
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thouma.concepts.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {
        // Aplica o remueve el tachado según el estado de la tarea
        if (task.isSelected) {
            // Aplica el tachado
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            // Remueve el tachado
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        // Establece el texto de la tarea
        tvTask.text = task.name
        // Establece el estado del CheckBox
        cbTask.isChecked = task.isSelected
        Log.i("Richard", "render: " + "$task")
        var colorCategory = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Personal -> R.color.todo_personal_category
            TaskCategory.Other -> R.color.todo_other_category
        }

        // Pintar el checkbox si está seleccionado con el color de la categoria
        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, colorCategory)
        )
    }
}