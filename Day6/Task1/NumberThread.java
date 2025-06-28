package Task1;

//Thread class that prints numbers 1 to 10
class NumberThread extends Thread {
 public void run() {
     for (int i = 1; i <= 10; i++) {
         System.out.println(Thread.currentThread().getName() + ": " + i);
         try {
             Thread.sleep(300); // Brief pause between numbers
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

 class Main {
 public static void main(String[] args) {
     // Create and start the thread
     NumberThread thread = new NumberThread();
     thread.start();
     
     // Main thread continues execution
     System.out.println("Main thread is running separately");
 }
}

