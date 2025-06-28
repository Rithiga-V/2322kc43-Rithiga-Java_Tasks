package Task2;

public class MessagePrinter implements Runnable {
    private String message;
    
    public MessagePrinter(String message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
            try {
                Thread.sleep(300); // Small delay to see thread interleaving
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
    
    public static void main(String[] args) {
        // Create Runnable instances
        Runnable printer1 = new MessagePrinter("Hello from Thread 1");
        Runnable printer2 = new MessagePrinter("Hello from Thread 2");
        
        // Create and start threads
        new Thread(printer1, "Thread-A").start();
        new Thread(printer2, "Thread-B").start();
        
        // Main thread continues execution
        System.out.println("Main thread executed concurrently");
    }
}
