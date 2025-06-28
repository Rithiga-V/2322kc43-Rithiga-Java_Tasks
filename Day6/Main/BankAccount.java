package Main;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(String user, double amount) {
        lock.lock(); 
        try {
            System.out.println(user + " attempting to withdraw $" + amount);
            
            if (balance >= amount) {
                
                Thread.sleep(500);
                
                balance -= amount;
                System.out.println("SUCCESS: " + user + " withdrew $" + amount + 
                                 " | New Balance: $" + balance);
            } else {
                System.out.println("FAILED: " + user + " - Insufficient funds for $" + amount + 
                                 " | Balance: $" + balance);
            }
        } catch (InterruptedException e) {
            System.out.println(user + "'s transaction was interrupted");
        } finally {
            lock.unlock(); // Always release the lock
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Customer implements Runnable {
    private BankAccount account;
    private String name;
    private double[] withdrawalAmounts;

    public Customer(BankAccount account, String name, double[] withdrawalAmounts) {
        this.account = account;
        this.name = name;
        this.withdrawalAmounts = withdrawalAmounts;
    }

    @Override
    public void run() {
        for (double amount : withdrawalAmounts) {
            try {
                
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(name, amount);
        }
    }
}
 class BankingApplication {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sharedAccount = new BankAccount(1000.00);
        
        
        Customer[] customers = {
            new Customer(sharedAccount, "Alice", new double[]{200, 300, 400}),
            new Customer(sharedAccount, "Bob", new double[]{150, 500, 100}),
            new Customer(sharedAccount, "Charlie", new double[]{700, 200})
        };

        
        Thread[] threads = new Thread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            threads[i] = new Thread(customers[i]);
            threads[i].start();
        }

        
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("\nFinal Account Balance: $" + sharedAccount.getBalance());
    }
}

