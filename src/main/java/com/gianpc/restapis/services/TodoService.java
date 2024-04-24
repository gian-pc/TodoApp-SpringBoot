package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // proveernos una sola instancia SINGLETON de esta clase durante toda la ejecución de la aplicacion
public class TodoService {

    public List<Todo> findAll(){
        return null;
    }
}
