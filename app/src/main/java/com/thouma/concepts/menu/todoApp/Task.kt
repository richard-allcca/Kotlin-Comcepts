package com.thouma.concepts.menu.todoApp

data class Task(val name: String, val category: TaskCategory, var isSelected: Boolean = true){

}