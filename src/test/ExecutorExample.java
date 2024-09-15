package test;

import java.util.concurrent.*;

// Class 1
// Helper Class implementing runnable interface Callable
class Task implements Callable<String> {
    // Member variable of this class
    private String message;

    // Constructor of this class
    public Task(String message) {
        // This keyword refers to current instance itself
        this.message = message;
    }

    // Method of this Class
    public String call() throws Exception {
        return "Hiiii " + message + "!";
    }
}

// Class 2
// Main Class
// ExecutorExample
public class ExecutorExample {

    // Main drive

    public static void main(String[] args) {

        // Creating an object of above class
        // in the main() method
        Task task = new Task("GeeksForGeeks");

        // Creating object of ExecutorService class and
        // Future object Class
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        Future<String> result
                = executorService.submit(task);

        // Try block to check for exceptions
        try {
            System.out.println(result.get());
        }

        // Catch block to handle the exception
        catch (InterruptedException
               | ExecutionException e) {

            // Display message only
            System.out.println(
                    "Error occurred while executing the submitted task");

            // Print the line number where exception occurred
            e.printStackTrace();
        }

        // Cleaning resource and shutting down JVM by
        // saving JVM state using shutdown() method
        executorService.shutdown();
    }
}
