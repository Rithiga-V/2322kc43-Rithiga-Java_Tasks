package Main;

import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    String position;

    Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + position;
    }
}

 class EmployeeRecordSystem {
    private static final String FILE_PATH = "employees.txt";

    
    public void addEmployee(Employee emp) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(emp.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length == 3) { // Ensure correctness of data length
                    employees.add(new Employee(Integer.parseInt(data[0]), data[1], data[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading employees: " + e.getMessage());
        }
        return employees;
    }

    
    public void updateEmployee(int id, Employee updatedEmp) {
        List<Employee> employees = getAllEmployees();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee emp : employees) {
                if (emp.id == id) {
                    writer.write(updatedEmp.toString());
                } else {
                    writer.write(emp.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }

    
    public void deleteEmployee(int id) {
        List<Employee> employees = getAllEmployees();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee emp : employees) {
                if (emp.id != id) {
                    writer.write(emp.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        EmployeeRecordSystem system = new EmployeeRecordSystem();
        
        // Adding Employees
        system.addEmployee(new Employee(1, "Alice", "Developer"));
        system.addEmployee(new Employee(2, "Bob", "Manager"));

        // Reading Employees
        List<Employee> employees = system.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Updating Employee
        system.updateEmployee(1, new Employee(1, "Alice Johnson", "Senior Developer"));

        // Deleting Employee
        system.deleteEmployee(2);

        // Final List of Employees
        employees = system.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
