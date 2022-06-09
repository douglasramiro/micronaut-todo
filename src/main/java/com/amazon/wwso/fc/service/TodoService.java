package com.amazon.wwso.fc.service;

import com.amazon.wwso.fc.model.Todo;
import com.amazon.wwso.fc.repository.TodoRepository;
import jakarta.inject.Singleton;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo saveTodo(@Valid Todo todo){
        LocalDateTime now = LocalDateTime.now();
        if (todo.getId() == null){
            todo.setCreatedAt(now);
        }
        todo.setUpdatedAt(now);
        return todoRepository.save(todo);
    }

    public List<Todo> listAll(){
        return todoRepository.findAll();
    }
}
