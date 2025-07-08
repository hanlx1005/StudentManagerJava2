import model.Student;
import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student By Id");
            System.out.println("3. Search for students by name");
            System.out.println("4. Display the list of students");
            System.out.println("5. Out");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(" Please enter a valid number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine());

                        Student student = new Student(id, name, gpa);
                        service.addStudent(student);
                        System.out.println(" Add Success!");
                        break;

                    case 2:
                        System.out.print("Enter the Id to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        if (service.deleteStudentById(deleteId)) {
                            System.out.println(" Deleted.");
                        } else {
                            System.out.println(" Student not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the name to search: ");
                        String keyword = sc.nextLine();
                        var result = service.searchStudentByName(keyword);
                        if (result.isEmpty()) {
                            System.out.println(" Not found.");
                        } else {
                            result.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        service.displayAllStudents();
                        break;

                    case 5:
                        System.out.println(" Goodbye!");
                        return;

                    default:
                        System.out.println(" Invalid choice. Please choose again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(" Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Unexpected error: " + e.getMessage());
            }
        }
    }
}
