package queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This program implements a producer-consumer model using a shared buffer backed by a {@link BlockingQueue}.
 * The producer generates items and adds them to the queue, while the consumer removes and processes them.
 * 
 * Classes:
 * - `Producer`: Produces items and adds them to the buffer.
 * - `Consumer`: Consumes items from the buffer.
 * - `ProducerConsumer`: Demonstrates the interaction between the producer and consumer.
 */
class Producer implements Runnable {
    private final BlockingQueue<Integer> buffer; // Shared buffer
    private int value = 0;                      // Value to produce
    private final int maxItems;                 // Maximum number of items to produce
    private volatile boolean running = true;    // Flag to control the producer's operation

    /**
     * Constructs a Producer with a shared buffer and a limit on items.
     * 
     * @param buffer   The shared {@link BlockingQueue}.
     * @param maxItems The maximum number of items to produce.
     */
    public Producer(BlockingQueue<Integer> buffer, int maxItems) {
        this.buffer = buffer;
        this.maxItems = maxItems;
    }

    /**
     * Stops the producer.
     */
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running && value < maxItems) {
            try {
                buffer.put(value); // Add item to the buffer
                System.out.println("Producer produced: " + value++);
                Thread.sleep(1000); // Simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupt status
                e.printStackTrace();
            }
        }
    }

    /**
     * Time Complexity: O(1) per item produced, for adding to the buffer.
     * Space Complexity: O(1) additional space, apart from the shared buffer.
     */
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> buffer; // Shared buffer
    private volatile boolean running = true;    // Flag to control the consumer's operation

    /**
     * Constructs a Consumer with a shared buffer.
     * 
     * @param buffer The shared {@link BlockingQueue}.
     */
    public Consumer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    /**
     * Stops the consumer.
     */
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                int consumedValue = buffer.take(); // Remove item from the buffer
                System.out.println("Consumer consumed: " + consumedValue);
                Thread.sleep(1000); // Simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupt status
            }
        }
    }

    /**
     * Time Complexity: O(1) per item consumed, for removing from the buffer.
     * Space Complexity: O(1) additional space, apart from the shared buffer.
     */
}

/**
 * Demonstrates the Producer-Consumer interaction using threads and a shared buffer.
 */
public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        // Shared buffer with a capacity of 5
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

        // Maximum number of items the producer should generate
        int maxItems = 10;

        // Create Producer and Consumer
        Producer producer = new Producer(buffer, maxItems);
        Consumer consumer = new Consumer(buffer);

        // Create and start threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        // Wait for the producer to finish
        producerThread.join();

        // Stop the consumer
        consumer.stop();

        System.out.println("Program completed");
    }

    /**
     * Time Complexity:
     * - Depends on the number of items produced/consumed.
     * - For N items:
     *   - Producer: O(N) to add items to the buffer.
     *   - Consumer: O(N) to remove items from the buffer.
     * 
     * Space Complexity:
     * - O(C), where C is the capacity of the shared buffer.
     * - The buffer's space usage depends on its capacity and current usage.
     */
}
