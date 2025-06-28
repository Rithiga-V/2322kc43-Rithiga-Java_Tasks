package Task2;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        // Create a HashSet to store unique email addresses
        HashSet<String> emailSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter email addresses (type 'exit' to finish):");
        
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            // Exit condition
            if (email.equalsIgnoreCase("exit")) {
                break;
            }
            
            // Add email to the HashSet
            if (emailSet.add(email)) {
                System.out.println("Email added: " + email);
            } else {
                System.out.println("Email already exists: " + email);
            }
        }
        
        // Display unique email addresses
        System.out.println("\nUnique Email Addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }
        
        scanner.close();
    }
}

