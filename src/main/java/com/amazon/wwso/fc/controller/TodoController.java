package com.amazon.wwso.fc.controller;

import com.amazon.wwso.fc.model.Todo;
import com.amazon.wwso.fc.service.TodoService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import java.util.List;

@Controller("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Get
    public HttpResponse<List<Todo>> listAll(){
        return HttpResponse.ok(todoService.listAll());
    }

    @Post
    public HttpResponse<Todo> addNewTodo(@Valid Todo newTodoRequest) {
        return HttpResponse.created(todoService.saveTodo(newTodoRequest));
    }
}
