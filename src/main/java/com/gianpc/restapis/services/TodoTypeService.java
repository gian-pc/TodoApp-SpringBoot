package com.gianpc.restapis.services;

import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.repositories.TodoTypeRepository;
import jakarta.persistence.SecondaryTable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TodoTypeService {

    private TodoTypeRepository todoTypeRepository;
    private Validator validator;

    @Autowired
    public TodoTypeService(TodoTypeRepository todoTypeRepository, Validator validator) {
        this.todoTypeRepository = todoTypeRepository;
        this.validator = validator;
    }


//    private static Map<String, TodoType> todoTypeCollection = new HashMap<>();


    public TodoType create(TodoType todoType) {
        Set<ConstraintViolation<TodoType>> violations = validator.validate(todoType);
        if(violations.size() < 1){ // no hay errores de validacion
            todoTypeRepository.save(todoType);
        }
        return todoType;
    }

    public TodoType findByCode(String code) {
        Optional<TodoType> todoTypeResult =  todoTypeRepository.findById(code);
        if (todoTypeResult.isPresent()) {
            return todoTypeResult.get();
        }else {
            return null;
        }
    }

    public TodoType update(TodoType todoType) {
        todoType.setLastUpdated(new Date());
        todoType = todoTypeRepository.save(todoType);
        return todoType;
    }

    public void deleteByCode(String code) throws Exception{
        if(!todoTypeRepository.existsById(code)){
            throw new Exception("No existe el " + code);
        }
        todoTypeRepository.deleteById(code);
    }
}