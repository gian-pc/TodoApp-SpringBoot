package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.services.TodoService;
import com.gianpc.restapis.services.TodoTypeService;
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

    // Aquí se implementan  todas las  operaciones  REST
    // Spring MVC a implementado los métodos HTTP
    // GET, POST, PUT, DELETE

    // El post es para hacer creaciones, actualizaciones e incluso para consultas
    // Lo bueno del post es que se puede enviar todo lo que queramos no hay un  límite
    // No se ve la información que se envía a menos que se intercepte
    // Se recomienda usar HTTPS para que el response y el request esten cifrados
    @PostMapping
    public Todo create(@Valid @RequestBody Todo todo){ // Recibe un objeto de tipo Todo y la anotación @RequestBody lo convierte a un objeto de tipo Todo
        return todoService.create(todo);
    }

    // El @GetMapping si tiene un límite de consultas, por que depende de lo que mandes en el URL
    // GET solo puede mandar 2048 caracteres
    // Si se ve la información que se envía
    @GetMapping("/{id}")
    // Yo quiero saber cuando llaman al read
    // El controller  nunca se entera que lo estan mirando
    @LogMethodDetails
    public ResponseEntity<Todo> read(@PathVariable("id") Long id){ // Lo que esta en el path eso que se llama id pásamelo a Long id
        Todo todo = todoService.findById(id);
        if(null!=todo){
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // El PUT sirve para un update
    @PutMapping
    public Todo update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    // Para eliminar
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
