package com.company;

//public class CompletableFutureExample {

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

    public class CompletableFutureExample {

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            // Create a list of CompletableFuture representing asynchronous tasks
            List<CompletableFuture<Boolean>> futures = new ArrayList<>();

            // Adding some CompletableFuture objects with randomly completed tasks (true or false)
            for (int i = 0; i < 5; i++) {
                CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> simulateTask());
                futures.add(future);
            }

            // Perform the reduction to check if all tasks completed successfully
            boolean allTasksCompleted = futures.stream()
                    .map(CompletableFuture::join) // Get the Boolean value from each CompletableFuture
                    .reduce(true, (x, y) -> x && y); // Perform logical AND operation

            System.out.println("All tasks completed successfully: " + allTasksCompleted);
        }

        // Simulate a task that returns a Boolean value (true or false) randomly
        private static boolean simulateTask() {
            Random random = new Random();
            return random.nextBoolean();
        }
    }

//}
