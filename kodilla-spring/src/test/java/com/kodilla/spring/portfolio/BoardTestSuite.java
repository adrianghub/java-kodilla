package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testAddTask() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().add("do the dishes");
        board.getToDoList().add("do the dishes");
        board.getToDoList().add("do the dishes");
        board.getInProgressList().add("do the dishes");
        board.getInProgressList().add("do the dishes");

        //Then
        assertEquals(3, board.getToDoList().size());
        assertEquals(2, board.getInProgressList().size());

    }
}
