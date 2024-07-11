package com.gianpc.restapis.integration;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import com.gianpc.restapis.repositories.TodoRepository;
import com.gianpc.restapis.repositories.TodoTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TodoRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoTypeRepository todoTypeRepository;

    @Test
    public void whenFindAllByType_thenReturnAllTodos(){
        //given
        TodoType personal = new TodoType();
        personal.setCode("PERSONAL");
        personal.setDateCreated(new Date());

        entityManager.persist(personal);

        Todo todo = new Todo();
        todo.setTitle("Tender mi cama");
        todo.setDateCreated(new Date());
        todo.setDueDate(new Date());
        todo.setTodoType(personal);

        Todo[] todos = new Todo[1];
        todos[0]= todo;

        entityManager.persist(todo);
        entityManager.flush();

        //when --> buscame todos los tod0s que e guardado, pero por el todotype
        List<Todo> found = todoRepository.findAllByTodoType(personal);
        //then
        assertArrayEquals(todos, found.toArray());
    }

    @Test
    public void givenTodoObjIsPersisted_whenFindByTitle_thenReturnTodoObj(){
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");
        todo.setDateCreated(new Date());
        todo.setDueDate(new Date());

        entityManager.persist(todo);
        entityManager.flush(); // flush: Fuerzas a que se ejecute la persistencia o sea que se guarde en la DB

        //when --> cuando buscar por titulo
        Todo found = todoRepository.findByTitle(todo.getTitle());

        //then --> entoces lo debes encontrar
        assertEquals(todo.getTitle(), found.getTitle()); // deben ser iguales el tod0 que mande a guardar con el que mande a buscar
    }

    @Test
    public void whenTodoObjIsSaved_thenTodoObjIsPersisted(){
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");
        todo.setDateCreated(new Date());
        todo.setDueDate(new Date());

        //when  --> cuando llamen al todoRepository y manden a grabar
        todoRepository.save(todo);

        //then -- entonces yo debería preguntar, este "tod0" debería ser el mismo que al buscarlo po id lo encuentre
        // esto se estaría probando contra la base de datos h2
        assertEquals(todo, todoRepository.findById(todo.getId()).get());
    }
}
