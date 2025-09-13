package com.gdl.spring.todoapp;

import com.gdl.spring.todoapp.Pojo.TodoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/todoList/{todoId}")
    public ResponseEntity<?> findTodoById(@PathVariable int todoId){
        for (TodoList l1:todoLists){
            if (l1.getId()==todoId){
                return ResponseEntity.status(HttpStatus.FOUND).body(l1);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Id not found");
    }
    @DeleteMapping("/todoList/{deleteId}")
    public ResponseEntity<?> deleteTodo(@PathVariable int deleteId){
        for (TodoList l1:todoLists){
            if (l1.getId()==deleteId){
               return ResponseEntity.status(HttpStatus.OK).body("Deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not Deleted. Id not found");
    }
}
