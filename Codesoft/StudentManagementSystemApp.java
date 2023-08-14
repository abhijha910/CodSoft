package Codesoft;

        import java.io.*;
        import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                student.displayDetails();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Students are as following:");
            for (Student student : students) {
                student.displayDetails();
                System.out.println();
            }
        }
    }
}

public class StudentManagementSystemApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Exiting the Application");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        system.removeStudent(rollNumber);
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        system.searchStudent(rollNumber);
    }

    private static void displayAllStudents() {
        system.displayAllStudents();
    }
}