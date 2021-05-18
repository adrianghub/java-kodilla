package com.kodilla.patterns.factory.tasks;

import java.util.Random;

import static com.kodilla.patterns.factory.tasks.GlobalVars.PROGRESS_GOAL_SCORE;

public class PaintingTask implements Task {

    private String taskName;
    private String whatToPaint;
    private String color;

    public PaintingTask(String taskName, String whatToPaint, String color) {
        this.taskName = taskName;
        this.whatToPaint = whatToPaint;
        this.color = color;
    }

    Random random = new Random();

    @Override
    public void executeTask() {
        System.out.println("Work in progress.. Painting " + whatToPaint + " using color " + color);
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
