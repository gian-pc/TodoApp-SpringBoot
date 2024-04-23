package com.gianpc.restapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combina  @Controller y @ResponseBody
@RequestMapping("/api/todoType") // Mapea los web requests a /api/todoType
public class TodoTypeController {

    @GetMapping("/hello") // Solo maneja peticiones GET
    public String hello() {
        return "Hello World from Spring Boot !";
    }

}
