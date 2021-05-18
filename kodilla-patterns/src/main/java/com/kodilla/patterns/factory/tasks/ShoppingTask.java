package com.kodilla.patterns.factory.tasks;

import java.util.Random;

import static com.kodilla.patterns.factory.tasks.GlobalVars.PROGRESS_GOAL_SCORE;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    Random random = new Random();

    @Override
    public void executeTask() {
        System.out.println("Work in progress.. Buying " + quantity + " X " + whatToBuy);
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
