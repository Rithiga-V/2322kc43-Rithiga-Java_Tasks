package Task3;

class Worker implements Runnable {
    private String name;
    private int duration;

    public Worker(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(name + " started working");
        
        try {
            // Simulate work with sleep()
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted");
        }

        System.out.println(name + " finished after " + duration + "ms");
    }
}

 class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        
        Thread worker1 = new Thread(new Worker("Worker 1", 2000));
        Thread worker2 = new Thread(new Worker("Worker 2", 3000));
        Thread worker3 = new Thread(new Worker("Worker 3", 1500));

        worker1.start();
        worker2.start();

        // Demonstrate sleep()
        System.out.println("Main thread sleeping for 1 second");
        try {
            Thread.sleep(1000); // Main thread sleeps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread woke up");

        // Demonstrate join()
        System.out.println("Main thread waiting for Worker 1 to complete");
        try {
            worker1.join(); // Main thread waits for worker1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        worker3.start();
        
        System.out.println("Main thread continues while Worker 2 and 3 run");
        
        try {
            worker2.join(); // Wait for worker2
            worker3.join(); // Wait for worker3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers completed. Main thread exiting");
    }
}

