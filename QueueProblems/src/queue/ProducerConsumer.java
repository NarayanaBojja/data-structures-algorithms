package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private BlockingQueue<Integer> buffer;
	private int value = 0;
	private int maxItems;
	private volatile boolean running = true;

	public Producer(BlockingQueue<Integer> buffer, int maxItems) {
		this.buffer = buffer;
		this.maxItems = maxItems;
	}

	public void stop() {
		running = false;
	}

	@Override
	public void run() {
		while (running && value < maxItems) {
			try {
				buffer.put(value);
				System.out.println("Producer produced: " + value++);
				Thread.sleep(1000); // Simulate production time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> buffer;
	private volatile boolean running = true;

	public Consumer(BlockingQueue<Integer> buffer) {
		this.buffer = buffer;
	}

	public void stop() {
		running = false;
	}

	@Override
	public void run() {
		while (running && !Thread.currentThread().isInterrupted()) {
			try {
				int consumedValue = buffer.take();
				System.out.println("Consumer consumed: " + consumedValue);
				Thread.sleep(1000); // Simulate consumption time
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);
		int maxItems = 10;

		Producer producer = new Producer(buffer, maxItems);
		Consumer consumer = new Consumer(buffer);

		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);

		producerThread.start();
		consumerThread.start();

		// Wait for the producer to finish producing items
		producerThread.join();

		// Stop consumer thread
		consumer.stop();
		System.out.println("Program completed");
	}

}
