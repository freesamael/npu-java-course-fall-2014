public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

    public static void main(String args[]) {
        final SynchronizedCounter c = new SynchronizedCounter();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++)
                    c.increment();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++)
                    c.decrement();
            }
        };

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("value=" + c.value());
    }
}