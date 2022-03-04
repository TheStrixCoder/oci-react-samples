package com.oracle.todoapp.service;

import com.oracle.todoapp.Repository.TodoItemRepository;
import com.oracle.todoapp.object.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> findAll(){
        List<TodoItem> todoItems = todoItemRepository.findAll();
        return todoItems;
    }

    public ResponseEntity<TodoItem> getEmployeeById(int id) {
        Optional<TodoItem> empData = todoItemRepository.findById(id);

        if (empData.isPresent()) {
            return new ResponseEntity<>(empData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public TodoItem addTodoItem(TodoItem todoItem){
        return todoItemRepository.save(todoItem);
    }

    public boolean deleteTodoItem(int id) {
        try {
            todoItemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public TodoItem updateEmployee(int id, TodoItem td) {
        Optional<TodoItem> todoItemData = todoItemRepository.findById(id);
        if (todoItemData.isPresent()) {

            TodoItem todoItem = todoItemData.get();
            todoItem.setId(id);
            todoItem.setCreated_at(td.getCreated_at());
            todoItem.setDescription(td.getDescription());
            todoItem.setDone(td.isDone());
            return todoItemRepository.save(todoItem);
        } else {

            return null;
        }
    }
}
