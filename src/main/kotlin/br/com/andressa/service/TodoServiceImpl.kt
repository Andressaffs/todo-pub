package br.com.andressa.service

import br.com.andressa.client.TodoClient
import br.com.andressa.model.Event
import br.com.andressa.model.EventTodo
import br.com.andressa.model.Todo
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton


@Singleton
class TodoServiceImpl(private val todoClient: TodoClient): TodoService {

    val logger = LoggerFactory.getLogger(this::class.java)


    override fun addTodo(todo: Todo): Todo {
        todoClient.sendTodo(EventTodo(Event.SAVETODO_TODO, todo))
        logger.info("enviando para o sub - salvo")
        return todo
    }

    override fun updateTodo(id: UUID, todo: Todo): Todo {
        todoClient.sendTodo(EventTodo(Event.PUTTODO_TODO, todo))
        logger.info("enviando para o sub - atualizado")
        return todo
    }

    override fun deleteTodo(id: UUID) {
        todoClient.sendTodo(EventTodo(Event.DELETETODO_TODO, Todo(null,"","",false)))
        logger.info("enviando para o sub - deletado")

    }
}