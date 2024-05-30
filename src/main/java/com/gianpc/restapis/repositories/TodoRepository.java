package com.gianpc.restapis.repositories;

import com.gianpc.restapis.domains.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    @Query("SELECT t FROM Todo t WHERE t.done = true")
    List<Todo> readAllDone();

    @Query("SELECT t FROM Todo t WHERE t.dateCreated >= ?1 AND t.dueDate = ?2")
    List<Todo> fetchTodos(Date dateCreated, Date dueDate);
}
