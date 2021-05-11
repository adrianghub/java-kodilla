package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("todo")
    TaskList toDoTasks;

    @Autowired
    @Qualifier("inprogress")
    TaskList inProgressTasks;

    @Autowired
    @Qualifier("done")
    TaskList doneTasks;

    @Bean
    public Board getBoard() {
        return new Board(toDoTasks, inProgressTasks, doneTasks);
    }

    @Bean (name = "todo")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean (name = "inprogress")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean (name = "done")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }
}
