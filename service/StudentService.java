package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("The ID already exists.");
            }
        }
        students.add(student);
    }

    public boolean deleteStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public ArrayList<Student> searchStudentByName(String keyword) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
