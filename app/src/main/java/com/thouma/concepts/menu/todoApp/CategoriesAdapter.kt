package com.thouma.concepts.menu.todoApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thouma.concepts.R

// Esta clase se encarga de adaptar una lista de TaskCategory a una lista de vistas en un RecyclerView
class CategoriesAdapter(private val categories: List<TaskCategory>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    // Función que se llama cuando se necesita crear una nueva instancia de CategoriesViewHolder
    // (una vista para cada elemento de la lista)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        // LayoutInflater se utiliza para convertir un archivo XML de layout en una vista de Android
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        // Crea una nueva instancia de CategoriesViewHolder con la vista inflada
        return CategoriesViewHolder(view)
    }

    // Función que devuelve el número total de elementos en la lista
    override fun getItemCount(): Int {
        return categories.size
    }

    // Función que enlaza los datos de un elemento de la lista a una vista
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        // Obtiene la categoría de la lista en la posición actual
        // función render del CategoriesViewHolder para mostrar los datos de la categoría en la vista
        holder.render(categories[position], onItemSelected)
    }
}