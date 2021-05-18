package com.kodilla.patterns.factory.tasks;

import java.util.Random;

import static com.kodilla.patterns.factory.tasks.GlobalVars.PROGRESS_GOAL_SCORE;

public class DrivingTask implements Task {

    private String taskName;
    private String where;
    private String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    Random random = new Random();

    @Override
    public void executeTask() {
        System.out.println("Work in progress.. Driving to " + where + " using " + using);
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (random.nextInt(16) >= PROGRESS_GOAL_SCORE) {
            return true;
        }
        return false;
    }

    public void displayTaskStatus() {
        if (isTaskExecuted()) {
            System.out.println("STATUS: DONE");
        } else {
            System.out.println("STATUS: PENDING");
        }
    }
}
