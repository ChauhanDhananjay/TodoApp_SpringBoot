package com.gdl.spring.todoapp;

import com.gdl.spring.todoapp.Pojo.TodoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TodoList>> getAllTodoList(){
        return ResponseEntity.ok(todoLists);
    }
    @PostMapping("/todolist")
    public ResponseEntity<TodoList> createTodo(@RequestBody TodoList newToDo){
        todoLists.add(newToDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDo);
    }
}
