package br.com.andressa.model

data class EventTodo (

//    val event: Event = Event.SAVETODO_TODO,
    val event: Event,
    val todo: Todo = Todo(null,"", "",false)
    )
