package com.kodilla.spring.portfolio;

import java.util.List;

public final class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public List<String> getToDoList() {
        return toDoList.getTasks();
    }

    public List<String> getInProgressList() {
        return inProgressList.getTasks();
    }

    public List<String> getDoneList() {
        return doneList.getTasks();
    }
}
