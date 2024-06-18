import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private final String studentId;
    private String name;
    private double marks;

    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String rank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }
}

class StudentManagement {
    private final List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, double marks) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                throw new IllegalArgumentException("Student ID must be unique");
            }
        }
        students.add(new Student(studentId, name, marks));
    }

    public void editStudent(String studentId, String name, double marks) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setName(name);
                student.setMarks(marks);
                return;
            }
        }
        throw new IllegalArgumentException("Student not found");
    }

    public void deleteStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> sortStudentsByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        return students;
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==================================");
            System.out.println("|        Student Management      |");
            System.out.println("==================================");
            System.out.println("| 1. Add Student                 |");
            System.out.println("| 2. Edit Student                |");
            System.out.println("| 3. Delete Student              |");
            System.out.println("| 4. View All Students           |");
            System.out.println("| 5. Sort Students by Marks      |");
            System.out.println("| 6. Search Student by Name      |");
            System.out.println("| 7. Exit                        |");
            System.out.println("==================================");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter Student Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Student Marks:");
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    studentManagement.addStudent(studentId, name, marks);
                    break;
                case 2:
                    System.out.println("Enter Student ID:");
                    studentId = scanner.nextLine();
                    System.out.println("Enter Student Name:");
                    name = scanner.nextLine();
                    System.out.println("Enter Student Marks:");
                    marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    studentManagement.editStudent(studentId, name, marks);
                    break;
                case 3:
                    System.out.println("Enter Student ID:");
                    studentId = scanner.nextLine();
                    studentManagement.deleteStudent(studentId);
                    break;
                case 4:
                    List<Student> students = studentManagement.getAllStudents();
                    for (Student student : students) {
                        System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName() +
                                ", Marks: " + student.getMarks() + ", Rank: " + student.rank());
                    }
                    break;
                case 5:
                    List<Student> sortedStudents = studentManagement.sortStudentsByMarks();
                    for (Student student : sortedStudents) {
                        System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName() +
                                ", Marks: " + student.getMarks() + ", Rank: " + student.rank());
                    }
                    break;
                case 6:
                    System.out.println("Enter Student Name:");
                    name = scanner.nextLine();
                    List<Student> foundStudents = studentManagement.searchStudentByName(name);
                    for (Student student : foundStudents) {
                        System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName() +
                                ", Marks: " + student.getMarks() + ", Rank: " + student.rank());
                    }
                    break;
                case 7:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
