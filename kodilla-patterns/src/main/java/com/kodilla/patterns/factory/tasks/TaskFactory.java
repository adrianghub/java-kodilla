package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String SHOPPING_TASK = "SHOPPING TASK";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Drive back from car service", "garage", "own car");
            case PAINTING_TASK:
                return new PaintingTask("Freelance workshop", "Moon in the sky", "grey");
            case SHOPPING_TASK:
                return new ShoppingTask("Christmas Eve groceries", "oranges", 44);
            default:
                return null;
        }
    }
}
