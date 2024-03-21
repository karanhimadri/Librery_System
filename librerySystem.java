import java.util.Random;
import java.util.Scanner;

class Student {
    private String name;
    private int studentID;
    private String rollNumber;
    private String stream;

    // Constructor to initialize the student profile
    public Student(String name, int studentID, String rollNumber, String stream) {
        this.name = name;
        this.studentID = studentID;
        this.rollNumber = rollNumber;
        this.stream = stream;
    }

    // Getter methods to access the information
    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getStream() {
        return stream;
    }

    // Setter methods to update information
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}

public class librerySystem {

    public static int nameSearching(Student students[], int size, String targetStudent) {
        for (int i = 0; i < size; i++) {
            if (students[i].getName().equalsIgnoreCase(targetStudent)) {
                return i;
            }
        }
        return -1;
    }

    public static void optionDisplay() {
        System.out.println("1. Add Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. Display Student Profile");
        System.out.println("0. Exit");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Student[] students = new Student[1000];

        String targetStudent = "";
        int index = 0;
        int size = 0;

        optionDisplay();
        while (true) {
            System.out.print("Enter Your Wish : ");
            int choice = sc.nextInt();

            if (choice == 0) { // Exit condition for the infinite loop
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("How many students want to make ID : ");
                    size = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    for (int i = 0; i < size; i++) {
                        System.out.print("Name : ");
                        String name = sc.next();

                        int studentID = random.nextInt(89999) + 10000;

                        System.out.print("Roll Number : ");
                        String rollNumber = sc.next();

                        System.out.print("Stream : ");
                        String stream = sc.next();

                        System.out.println();
                        students[i] = new Student(name, studentID, rollNumber, stream);
                    }
                    break;

                case 2:
                    System.out.print("Enter student name for Searching : ");
                    targetStudent = sc.next();
                    index = nameSearching(students, size, targetStudent);

                    if (index != -1) {
                        System.out.print("Enter New Name (press Enter to keep it unchanged): ");
                        String fatherName = sc.nextLine();
                        if (fatherName.isEmpty()) {
                            // If the input is empty, keep the existing fatherName
                            fatherName = students[index] != null ? students[index].getName() : "";
                        }
                        System.out.print("Enter New Student ID : ");
                        int updateStudentID = sc.nextInt();
                        students[index].setStudentID(updateStudentID);

                        System.out.print("Enter New Roll Number : ");
                        String updateRollNumber = sc.next();
                        students[index].setRollNumber(
                                updateRollNumber.isEmpty() ? students[index].getRollNumber() : updateRollNumber);

                        System.out.print("Enter New Stream : ");
                        String updateStream = sc.next();
                        students[index].setStream(updateStream.isEmpty() ? students[index].getStream() : updateStream);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter student name for Searching : ");
                    targetStudent = sc.next();
                    index = nameSearching(students, size, targetStudent);

                    if (index != -1) {
                        System.out.println("Name: " + students[index].getName());
                        System.out.println("Student ID: " + students[index].getStudentID());
                        System.out.println("Roll Number: " + students[index].getRollNumber());
                        System.out.println("Stream: " + students[index].getStream());
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

        sc.close();
    }
}
