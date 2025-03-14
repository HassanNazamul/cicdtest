package com.hassan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hassan.demo.model.Todo;
import com.hassan.demo.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("todo", new Todo());
        model.addAttribute("list", todoService.getTodo());
        return "index";
    }

    @PostMapping("/saveTodo")
    public String addTask(@RequestParam("name") String name) {
        todoService.addTodo(name);
        return "redirect:/";
    }

    @GetMapping("/deleteTodo/{index}")
    public String deleteTodo(@PathVariable int index) {
    todoService.removeTodo(index);
    return "redirect:/";
    }
    
    @PostMapping("/editTodo")
    public String editTodo(@RequestParam("index") int index, @RequestParam("name") String name) {
        todoService.editTodo(index, name);
        return "redirect:/";
    }
}
