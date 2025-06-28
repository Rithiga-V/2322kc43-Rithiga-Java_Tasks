package Task1;

import java.util.ArrayList;
import java.util.Iterator;

class Student {
    private String name;
    private int age;
    private String major;

    // Constructor
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}

 class StudentList {
    public static void main(String[] args) {
        // Create an ArrayList of Student objects
        ArrayList<Student> students = new ArrayList<>();

        // Add Student objects to the ArrayList
        students.add(new Student("Alice", 20, "Computer Science"));
        students.add(new Student("Bob", 22, "Mathematics"));
        students.add(new Student("Charlie", 21, "Physics"));

        // Create an Iterator to traverse the ArrayList
        Iterator<Student> iterator = students.iterator();

        // Display the students using the Iterator
        System.out.println("Student List:");
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
    }
}
