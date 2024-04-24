package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    // Aquí se implementan  todas las  operaciones  REST
    // Spring MVC a implementado los métodos HTTP
    // GET, POST, PUT, DELETE

    // El post es para hacer creaciones, actualizaciones e incluso para consultas
    // Lo bueno del post es que se puede enviar todo lo que queramos no hay un  límite
    // No se ve la información que se envía a menos que se intercepte
    // Se recomienda usar HTTPS para que el response y el request esten cifrados
    @PostMapping
    public Todo create(){
        // ...
    }

    // El @GetMapping si tiene un límite de consultas, por que depende de lo que mandes en el URL
    // GET solo puede mandar 2048 caracteres
    // Si se ve la información que se envía
    @GetMapping
    public Todo read(){

    }

    // El PUT sirve para un update
    @PutMapping
    public Todo update(){

    }

    // Para eliminar
    @DeleteMapping
    public void delete(){

    }
}
