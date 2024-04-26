package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service // proveernos una sola instancia SINGLETON de esta clase durante toda la ejecución de la aplicacion
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //    private static Map<Long, Todo> todoCollection = new HashMap<>();
//    private static long idCount = 1L;


    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(Long id) {
        Optional<Todo> todoResult = todoRepository.findById(id);
        if (todoResult.isPresent()) {
            return todoResult.get();
        }else {
            return null;
        }
    }

    public Todo update(Todo todo) {
        todo.setLastUpdated(new Date());
        if (todo.isDone()) {
            todo.setDateDone(new Date());
        }
        todo = todoRepository.save(todo);
        return todo;
    }

    public void deleteById(Long id) throws Exception{
        if(!todoRepository.existsById(id)){
            throw new Exception("No existe el " + id);
        }
        todoRepository.deleteById(id);
    }
}
