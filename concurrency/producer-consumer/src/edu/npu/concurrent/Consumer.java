package edu.npu.concurrent;

public class Consumer extends Thread {
	private Producer producer;

	Consumer(Producer p) {
		producer = p;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = producer.getMessage();
				System.out.println("Got message: " + message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
	}
}
