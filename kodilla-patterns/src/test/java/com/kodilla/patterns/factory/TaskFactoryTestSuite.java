package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    private static final String DRIVING_TASK_NAME = "Drive back from car service";
    private static final String PAINTING_TASK_NAME = "Freelance workshop";
    private static final String SHOPPING_TASK_NAME = "Christmas Eve groceries";

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING_TASK);
        //Then
        assertEquals(DRIVING_TASK_NAME, drivingTask.getTaskName());
        System.out.println("Task: " + drivingTask.getTaskName());
        drivingTask.executeTask();
        drivingTask.displayTaskStatus();
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.createTask(TaskFactory.PAINTING_TASK);
        //Then
        assertEquals(PAINTING_TASK_NAME, paintingTask.getTaskName());
        System.out.println("Task: " + paintingTask.getTaskName());
        paintingTask.executeTask();
        paintingTask.displayTaskStatus();
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING_TASK);
        //Then
        assertEquals(SHOPPING_TASK_NAME, shoppingTask.getTaskName());
        System.out.println("Task: " + shoppingTask.getTaskName());
        shoppingTask.executeTask();
        shoppingTask.displayTaskStatus();
    }
}
