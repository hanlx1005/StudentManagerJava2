package model;

public class Student {
    private int id;
    private String fullName;
    private double gpa;

    public Student(int id, String fullName, double gpa) {
        if (fullName.length() > 50) {
            System.out.println("The name must not exceed 50 characters.");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("GPA must be between 0.0 and 4.0.");
        }
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-20s | GPA: %.2f", id, fullName, gpa);
    }
}
