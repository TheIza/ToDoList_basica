package org.insbaixcamp.todolist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class TareaAdapter(private val tareas: ArrayList<String>) :
    RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoTarea: EditText = itemView.findViewById(R.id.pt_TextoTarea)
        val botonPapelera: Button = itemView.findViewById(R.id.bt_papelera)
        val checkBox: CheckBox = itemView.findViewById(R.id.ch_checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)

        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        holder.textoTarea.setText(tareas[position])

        holder.botonPapelera.setOnClickListener {
            tareas.removeAt(position)
            notifyItemRemoved(position)
        }

        holder.checkBox.setOnCheckedChangeListener { _, marcado ->
            if (marcado) {
                holder.textoTarea.paintFlags =
                    holder.textoTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.textoTarea.paintFlags =
                    holder.textoTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }

    override fun getItemCount(): Int {
        return tareas.size
    }
}