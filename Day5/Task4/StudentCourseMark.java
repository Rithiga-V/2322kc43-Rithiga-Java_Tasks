package Task4;

import java.util.*;

 class StudentCourseMark {
    private List<String> students = new ArrayList<>();
    private Map<String, List<String>> studentCourses = new HashMap<>();

    // Add a new student
    public void addStudent(String studentName) {
        if (!students.contains(studentName)) {
            students.add(studentName);
            studentCourses.put(studentName, new ArrayList<>());
            System.out.println(studentName + " added successfully.");
        } else {
            System.out.println(studentName + " is already enrolled.");
        }
    }

    // Remove a student
    public void removeStudent(String studentName) {
        if (students.remove(studentName)) {
            studentCourses.remove(studentName);
            System.out.println(studentName + " removed successfully.");
        } else {
            System.out.println(studentName + " not found.");
        }
    }

    // Enroll student in a course
    public void enrollCourse(String studentName, String courseName) {
        List<String> courses = studentCourses.get(studentName);
        if (courses != null) {
            if (!courses.contains(courseName)) {
                courses.add(courseName);
                System.out.println(courseName + " added for " + studentName);
            } else {
                System.out.println(studentName + " is already enrolled in " + courseName);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all students and their courses
    public void displayEnrollments() {
        System.out.println("\n--- Student Enrollments ---");
        Iterator<String> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            String student = studentIterator.next();
            List<String> courses = studentCourses.get(student);
            System.out.println("Student: " + student);
            if (courses != null && !courses.isEmpty()) {
                Iterator<String> courseIterator = courses.iterator();
                System.out.print("Courses: ");
                while (courseIterator.hasNext()) {
                    System.out.print(courseIterator.next());
                    if (courseIterator.hasNext()) System.out.print(", ");
                }
                System.out.println();
            } else {
                System.out.println("Courses: None");
            }
        }
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        StudentCourseMark system = new StudentCourseMark();
        
        system.addStudent("Alice");
        system.addStudent("Bob");
        
        system.enrollCourse("Alice", "Math");
        system.enrollCourse("Alice", "Physics");
        system.enrollCourse("Bob", "Chemistry");

        system.displayEnrollments();

        system.removeStudent("Alice");

        system.displayEnrollments();
    }
}