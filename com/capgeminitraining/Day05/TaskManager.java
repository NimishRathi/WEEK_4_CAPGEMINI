package com.capgeminitraining.Day05;

public class TaskManager {
    public static String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulates a long-running task (3 seconds)
        return "Task Completed";
    }
}
