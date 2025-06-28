package Task3;

import java.util.HashMap;
import java.util.Map;

public class StudentMarks {
    public static void main(String[] args) {
        // Create a HashMap to store student names and their marks
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // Adding some students and their marks
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 78);
        studentMarks.put("Charlie", 92);
        studentMarks.put("Diana", 88);
        studentMarks.put("Ethan", 76);

        // Calculate the average marks
        double average = calculateAverage(studentMarks);
        
        // Print the average
        System.out.printf("The average marks of the students is: %.2f%n", average);
    }

    public static double calculateAverage(HashMap<String, Integer> marks) {
        int totalMarks = 0;
        int numberOfStudents = marks.size();

        // Sum up all the marks
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            totalMarks += entry.getValue();
        }

        // Calculate average
        return numberOfStudents > 0 ? (double) totalMarks / numberOfStudents : 0;
    }
}
