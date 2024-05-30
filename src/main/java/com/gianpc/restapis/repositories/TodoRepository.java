package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {

    // ---------------- Finders ---------------

    // Si yo te diera el titulo de los Todos me puedes dar ese Todo por titulo
    Todo findByTitle(String title);

    // Buscar por la fecha de creación que sea mayor a la fecha que se le pasa como parámetro
    Todo findByDateCreatedGreaterThanEqual(Date dateCreated);

    // Buscar las tareas que estan hechas y su fecha de termino
    Todo findByDoneAndDateDone(Boolean done, Date dateDone);

    // Spring Data está permitiendo en lugar de findBy: readBy, getBy
    long countByDueDateLessThan(Date dueDate);
    long countByDateCreatedGreaterThanAndDueDate(Date dateCreated, Date dueDate);
    void deleteById(long id);
    long deleteByTitleAndDone(String title, Boolean done);
}
