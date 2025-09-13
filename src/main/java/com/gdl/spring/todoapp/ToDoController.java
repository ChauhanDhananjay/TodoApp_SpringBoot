package com.gdl.spring.todoapp;

import com.gdl.spring.todoapp.Pojo.TodoList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {
    private static List<TodoList> todoLists;
    public ToDoController(){
        todoLists = new ArrayList<>();
        todoLists.add(new TodoList(1,1,"task 1",false));
        todoLists.add(new TodoList(2,2,"task 2",false));
    }
    @GetMapping("/todolist")
    public List<TodoList> getAllTodoList(){
        return todoLists;
    }
    @PostMapping("/todolist")
    public TodoList createTodo(@RequestBody TodoList newToDo){
        todoLists.add(newToDo);
        return newToDo;
    }
}
