package org.insbaixcamp.todolist

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
class MainActivity : AppCompatActivity() {

    val tareas = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val botonPlus: Button = findViewById(R.id.bt_suma)
        val lista: RecyclerView = findViewById(R.id.rv_lista)
        lista.layoutManager = LinearLayoutManager(this)

        val adapter = TareaAdapter(tareas)
        lista.adapter = adapter

        botonPlus.setOnClickListener {
            tareas.add("Nueva Tarea")
            adapter.notifyDataSetChanged()
        }
    }
}