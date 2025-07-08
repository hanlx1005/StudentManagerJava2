package main;

import service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        displayMenu(service, sc);
    }

    private static void displayMenu(StudentService service, Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    handleAddStudent(service, sc);
                    break;
                case 2:
                    handleDeleteStudent(service, sc);
                    break;
                case 3:
                    handleSearchStudent(service, sc);
                    break;
                case 4:
                    service.displayAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void handleAddStudent(StudentService service, Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(sc.nextLine());

        try {
            service.addStudent(id, name, gpa);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleDeleteStudent(StudentService service, Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean deleted = service.deleteStudent(id);
        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void handleSearchStudent(StudentService service, Scanner sc) {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        service.searchStudent(name);
    }
}
