package com.greenfoxacademy.todoapi.repositories;

import com.greenfoxacademy.todoapi.models.Todo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TodoRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private TodoRepository todoRepository;

  private Todo firstTodo;
  private Todo secondTodo;
  private Todo thirdTodo;

  @Before
  public void setUp() {
    firstTodo = new Todo();
    firstTodo.setTitle("Feed the dog");
    firstTodo.setIsUrgent(false);
    firstTodo.setIsDone(false);
    secondTodo = new Todo();
    secondTodo.setTitle("Read Clean Code");
    secondTodo.setIsUrgent(true);
    secondTodo.setIsDone(false);
    thirdTodo = new Todo();
    thirdTodo.setTitle("Drink water");
    thirdTodo.setIsUrgent(true);
    thirdTodo.setIsDone(true);
  }

  @Test
  public void findAll() throws Exception {
    //given
    entityManager.persist(firstTodo);
    entityManager.persist(secondTodo);
    entityManager.persist(thirdTodo);
    entityManager.flush();

    //when
    List<Todo> todoList = todoRepository.findAll();

    //then
    assertThat(todoList.size()).isEqualTo(3);
    assertThat(todoList.get(0)).isEqualTo(firstTodo);
    assertThat(todoList.get(1)).isEqualTo(secondTodo);
    assertThat(todoList.get(2)).isEqualTo(thirdTodo);
  }
}