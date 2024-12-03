import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}

class Student {
    private String studentName;
    private int studentId;
    private ArrayList<Course> registeredCourses;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println(course.getCourseName() + " has been registered successfully.");
    }

    public void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }

    public void removeCourse(String courseCode) {
        boolean found = false;
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                registeredCourses.remove(course);
                System.out.println(course.getCourseName() + " has been removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course with code " + courseCode + " not found.");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("John Doe", 12345);

        while (true) {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Register a Course");
            System.out.println("2. View Registered Courses");
            System.out.println("3. Remove a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    Course course = new Course(courseName, courseCode);
                    student.registerCourse(course);
                    break;

                case 2:
                    student.viewRegisteredCourses();
                    break;

                case 3:
                    System.out.print("Enter Course Code to Remove: ");
                    String codeToRemove = scanner.nextLine();
                    student.removeCourse(codeToRemove);
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
