package com.gianpc.restapis.controllers;

import com.gianpc.restapis.domains.TodoType;
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

    /**
     * expose GetMapping en el /read endpoint
     * @return TodoType
     */
    @GetMapping("/read")
    public TodoType readTodoType() {
        TodoType todoType = new TodoType();
        todoType.setCode("PERSONAL");
        todoType.setDescription("Todo para personal stuff");
        return todoType;
    }

}
