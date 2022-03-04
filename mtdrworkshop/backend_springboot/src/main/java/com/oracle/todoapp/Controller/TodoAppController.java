package com.oracle.todoapp.Controller;

import com.oracle.todoapp.object.TodoItem;
import com.oracle.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoAppController {
    @Autowired
    private TodoItemService todoItemService;
    @CrossOrigin
    @GetMapping(value = "/todolist")
    public List<TodoItem> getAllTodoItems(){
        return todoItemService.findAll();
    }
    @CrossOrigin
    @GetMapping(value = "/todolist/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable int id){
        try {
            ResponseEntity<TodoItem> responseEntity = todoItemService.getEmployeeById(id);
            return new ResponseEntity<TodoItem>(responseEntity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @PostMapping(value = "/todolist")
    public ResponseEntity addTodoItem(@RequestBody TodoItem todoItem) throws Exception {

        TodoItem td=todoItemService.addTodoItem(todoItem);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("location",
                ""+td.getId());
        responseHeaders.set("Access-Control-Expose-Headers","location");
        //URI location = URI.create(""+td.getId());
        return  ResponseEntity.ok()
                .headers(responseHeaders).build();
    }
    @CrossOrigin
    @PutMapping(value = "todolist/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@RequestBody TodoItem todoItem, @PathVariable int id) {
        try {
            TodoItem todoItem1 = todoItemService.updateEmployee(id, todoItem);
            System.out.println(todoItem1.toString());
            return new ResponseEntity<>(todoItem1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping(value = "todolist/{id}")
    public ResponseEntity<Boolean> deleteTodoItem(@PathVariable("id") int id) {

        Boolean flag = false;
        try {
            flag = todoItemService.deleteTodoItem(id);
            return new ResponseEntity<>(flag, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(flag, HttpStatus.NOT_FOUND);
        }
    }
}
