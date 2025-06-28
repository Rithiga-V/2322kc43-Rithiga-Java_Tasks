package Main;

import java.util.*;
import java.io.*;

public class StudentManagementSystem {
    private ArrayList<String> studentNames;
    private HashMap<String, HashSet<String>> studentCourses;
    private static final String FILE_NAME = "students.txt";

    public StudentManagementSystem() {
        studentNames = new ArrayList<>();
        studentCourses = new HashMap<>();
    }

    // Add a new student
    public boolean addStudent(String studentId, String name) {
        if (studentCourses.containsKey(studentId)) {
            return false;
        }
        studentNames.add(name);
        studentCourses.put(studentId, new HashSet<>());
        return true;
    }

    // Remove a student
    public boolean removeStudent(String studentId) {
        if (!studentCourses.containsKey(studentId)) {
            return false;
        }
        int index = findStudentIndex(studentId);
        if (index != -1) {
            studentNames.remove(index);
        }
        studentCourses.remove(studentId);
        return true;
    }

    // Add course for student
    public boolean addCourse(String studentId, String course) {
        if (!studentCourses.containsKey(studentId)) {
            return false;
        }
        return studentCourses.get(studentId).add(course);
    }

    // Remove course from student
    public boolean removeCourse(String studentId, String course) {
        if (!studentCourses.containsKey(studentId)) {
            return false;
        }
        return studentCourses.get(studentId).remove(course);
    }

    // Search for a student
    public void searchStudent(String studentId) {
        if (!studentCourses.containsKey(studentId)) {
            System.out.println("Student not found!");
            return;
        }
        int index = findStudentIndex(studentId);
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + studentNames.get(index));
        System.out.println("Courses: " + String.join(", ", studentCourses.get(studentId)));
    }

    // Display all students
    public void displayAllStudents() {
        System.out.println("\nAll Students:");
        Iterator<String> idIterator = studentCourses.keySet().iterator();
        int counter = 0;
        
        while (idIterator.hasNext()) {
            String id = idIterator.next();
            int index = findStudentIndex(id);
            System.out.println((counter + 1) + ". ID: " + id + 
                             ", Name: " + studentNames.get(index) + 
                             ", Courses: " + String.join(", ", studentCourses.get(id)));
            counter++;
        }
    }

    // Save to file
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String id : studentCourses.keySet()) {
                int index = findStudentIndex(id);
                writer.println(id + "," + studentNames.get(index) + "," + 
                              String.join(",", studentCourses.get(id)));
            }
            System.out.println("Data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Helper method to find student index by ID
    private int findStudentIndex(String studentId) {
        Iterator<String> idIterator = studentCourses.keySet().iterator();
        int currentIndex = 0;
        
        while (idIterator.hasNext()) {
            if (idIterator.next().equals(studentId)) {
                return currentIndex;
            }
            currentIndex++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Course");
            System.out.println("4. Remove Course");
            System.out.println("5. Search Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Save to File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    if (system.addStudent(id, name)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Student already exists!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    id = scanner.nextLine();
                    if (system.removeStudent(id)) {
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Course to add: ");
                    String course = scanner.nextLine();
                    if (system.addCourse(id, course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Student not found or course already exists!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Course to remove: ");
                    course = scanner.nextLine();
                    if (system.removeCourse(id, course)) {
                        System.out.println("Course removed successfully!");
                    } else {
                        System.out.println("Student or course not found!");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    id = scanner.nextLine();
                    system.searchStudent(id);
                    break;
                    
                case 6:
                    system.displayAllStudents();
                    break;
                    
                case 7:
                    system.saveToFile();
                    break;
                    
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

