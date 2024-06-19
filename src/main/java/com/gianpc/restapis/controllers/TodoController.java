package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoService;
import com.gianpc.restapis.services.TodoTypeService;
import com.gianpc.restapis.utils.aop.AuditLoggable;
import com.gianpc.restapis.utils.aop.LogMethodDetails;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;
    private TodoTypeService todoTypeService;

    @Autowired
    public TodoController(TodoService todoService, TodoTypeService todoTypeService) {
        this.todoService = todoService;
        this.todoTypeService = todoTypeService;
    }

    @PostMapping
    public Todo create(@Valid @RequestBody Todo todo){
        ((AuditLoggable)todoService).auditLog(todo, "INSERT");
        return todoService.create(todo);
    }


    @GetMapping("/{id}")
    @LogMethodDetails
    public ResponseEntity<Todo> read(@PathVariable("id") Long id){ // Lo que esta en el path eso que se llama id pásamelo a Long id
        Todo todo = todoService.findById(id);
        if(null!=todo){
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo){
        ((AuditLoggable)todoService).auditLog(todo, "UPDATE");
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            todoService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    @LogMethodDetails
    public List<Todo> findAll(@RequestParam String sort, @RequestParam String order, @RequestParam int pageNumber, @RequestParam int numOfRecords) {
        return todoService.findAll(sort, Sort.Direction.fromString(order) , pageNumber, numOfRecords);
    }
}
