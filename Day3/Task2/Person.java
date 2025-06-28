package Task2;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}

 class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 30, 3000.00);
        emp.displayInfo();
    }
}
