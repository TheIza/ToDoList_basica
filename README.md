# ToDoList

Aplicación Android sencilla para gestionar una lista de tareas.

El proyecto está desarrollado con **Kotlin** y utiliza **RecyclerView** para mostrar las tareas dinámicamente.

## Funcionalidades actuales

- Añadir nuevas tareas mediante el botón `+`.
- Mostrar las tareas en una lista.
- Editar el texto de las tareas directamente desde el `EditText`.
- Eliminar tareas mediante el botón de papelera.
- Marcar tareas como completadas mediante un `CheckBox`.
- Al marcar una tarea como completada, el texto aparece tachado.
- Al desmarcarla, el texto vuelve a su estado normal.

## Estructura

### MainActivity

Se encarga de:

- Inicializar la interfaz.
- Crear el `ArrayList` donde se almacenan las tareas.
- Configurar el `RecyclerView`.
- Crear y asignar el `TareaAdapter`.
- Añadir nuevas tareas al pulsar el botón `+`.

Actualmente las tareas se almacenan en memoria mediante:

```kotlin
val tareas = ArrayList<String>()
```

### TareaAdapter

El `Adapter` se encarga de conectar los datos de las tareas con cada elemento visual de la lista.

Gestiona:

- El texto de cada tarea.
- El botón de eliminar.
- El `CheckBox`.
- El tachado del texto cuando una tarea está completada.

### item_lista.xml

Define el diseño visual de cada tarea.

Cada elemento contiene:

- `CheckBox` para marcar la tarea como completada.
- `EditText` para mostrar y editar el texto.
- Botón de papelera para eliminar la tarea.

## RecyclerView

Las tareas se muestran utilizando un `RecyclerView` junto con un `LinearLayoutManager`.

El `RecyclerView` permite reutilizar las vistas de las tareas y mostrar una lista de elementos de forma eficiente.

## Importante: almacenamiento

Actualmente **las tareas NO se guardan de forma permanente**.

Las tareas solamente se almacenan en el `ArrayList` mientras la aplicación está ejecutándose.

Si se cierra la aplicación, los datos se pierden.

Para que las tareas puedan mantenerse después de cerrar y volver a abrir la aplicación, será necesario conectar el proyecto a un sistema de almacenamiento permanente, por ejemplo:

- **Room / SQLite** → base de datos local en el dispositivo.
- **Firebase** → almacenamiento en la nube y posibilidad de sincronizar los datos.

La siguiente evolución del proyecto será conectar las tareas a una **base de datos o Firebase** para que puedan guardarse permanentemente.

## Tecnologías

- Kotlin
- Android Studio
- Android SDK
- RecyclerView
- ConstraintLayout
- Material Components

## Estado del proyecto

**Terminado**

Este proyecto lo utilice para aprender, por eso no conecte ninguna base de datos ni firebase o de el estilo para que las tareas realmente se guardaran.
