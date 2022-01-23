package com.yagu238.todo2.controller

import org.springframework.web.bind.annotation.*

data class Todo(val id: Int, val title: String?, val completed: Boolean)

@RestController
@RequestMapping("/todo")
class TodoController {
    val todoList = listOf(
            Todo(1, "todoTitle1", false),
            Todo(2, "todoTitle2", true),
            Todo(3, "todoTitle3", false)
    )

    @GetMapping
    fun getTodoListApi(): List<Todo> {
        return todoList
    }

    @GetMapping("{id}")
    fun getTodoApi(@PathVariable id: Int): Todo {
        val index = todoList.indexOfFirst { todo -> todo.id == id }
        return todoList[index]
    }
}