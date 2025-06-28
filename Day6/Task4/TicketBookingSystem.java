package Task4;

class TicketBookingSystem {
    private int availableSeats;
    private final int totalSeats;

    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    // Synchronized method to book tickets
    public synchronized boolean bookTicket(String user, int seatsRequested) {
        System.out.println(user + " is trying to book " + seatsRequested + " seat(s)");
        
        if (availableSeats >= seatsRequested) {
            // Simulate processing delay
            try {
                Thread.sleep(500); // Time to process payment, etc.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            availableSeats -= seatsRequested;
            System.out.println("SUCCESS: " + user + " booked " + seatsRequested + " seat(s). Remaining: " + availableSeats);
            return true;
        } else {
            System.out.println("FAILED: Not enough seats for " + user + ". Requested: " + seatsRequested + ", Available: " + availableSeats);
            return false;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class TicketBookingUser implements Runnable {
    private TicketBookingSystem bookingSystem;
    private String userName;
    private int seatsNeeded;

    public TicketBookingUser(TicketBookingSystem bookingSystem, String userName, int seatsNeeded) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.seatsNeeded = seatsNeeded;
    }

    @Override
    public void run() {
        // Simulate user delay in making request
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        bookingSystem.bookTicket(userName, seatsNeeded);
    }
}

 class TicketBookingDemo {
    public static void main(String[] args) throws InterruptedException {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10);
        
        Thread[] users = new Thread[5];
        users[0] = new Thread(new TicketBookingUser(bookingSystem, "User-A", 3));
        users[1] = new Thread(new TicketBookingUser(bookingSystem, "User-B", 4));
        users[2] = new Thread(new TicketBookingUser(bookingSystem, "User-C", 2));
        users[3] = new Thread(new TicketBookingUser(bookingSystem, "User-D", 5));
        users[4] = new Thread(new TicketBookingUser(bookingSystem, "User-E", 1));

        System.out.println("Starting ticket booking with " + bookingSystem.getAvailableSeats() + " available seats\n");
        
        // Start all user threads
        for (Thread user : users) {
            user.start();
        }

        // Wait for all threads to complete
        for (Thread user : users) {
            user.join();
        }

        System.out.println("\nAll bookings processed. Final available seats: " + bookingSystem.getAvailableSeats());
    }
}

