package br.com.andressa.client

import br.com.andressa.model.EventTodo
import br.com.andressa.model.Todo
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsClient
interface TodoClient {

    @Subject("todo.scheduled")
    fun sendTodo(todo: EventTodo)

}