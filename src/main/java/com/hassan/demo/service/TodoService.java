package com.hassan.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hassan.demo.model.Todo;

@Service
public class TodoService {

    private final List<Todo> todo = new ArrayList<>();

    public List<Todo> getTodo() {
        return todo;
    }

    public void addTodo(String name) {
        todo.add(new Todo(name));
    }

    public void removeTodo(int index) {
        if (index >= 0 && index < todo.size())
            todo.remove(index);
    }
}
