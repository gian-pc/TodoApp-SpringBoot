package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Combina  @Controller y @ResponseBody
@RequestMapping("/api/todoType") // Mapea los web requests a /api/todoType
public class TodoTypeController {

    // Inyectando service
    private TodoTypeService todoTypeService; // null

    @Autowired
    public TodoTypeController(TodoTypeService todoTypeService) { // IoC e Inyección de dependencias
        this.todoTypeService = todoTypeService;
    }

    @GetMapping("/hello") // Solo maneja peticiones GET
    public String hello() {
        return "Hello World from Spring Boot !";
    }

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public TodoType create(@RequestBody TodoType todoType) {
        return todoTypeService.create(todoType);
    }

    @GetMapping(value = "/{code}", produces = {"application/xml"})
    public ResponseEntity<TodoType>  read(@PathVariable("code") String code) {
        TodoType todoType = todoTypeService.findByCode(code);
        if (null != todoType){
            return new ResponseEntity<>(todoType, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public TodoType updateTodo(@RequestBody TodoType todoType) {
        return todoTypeService.update(todoType);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable("code") String code) {
        try {
            todoTypeService.deleteByCode(code);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
