package com.oracle.todoapp.Repository;

import com.oracle.todoapp.object.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoItemRepository extends JpaRepository<TodoItem,Integer> {



}
