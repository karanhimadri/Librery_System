import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int studentID;
    private String rollNumber;
    private String stream;
    private List<String> booksHistory;

    // Constructor to initialize the student profile
    public Student(String name, int studentID, String rollNumber, String stream) {
        this.name = name;
        this.studentID = studentID;
        this.rollNumber = rollNumber;
        this.stream = stream;
        this.booksHistory = new ArrayList<>();
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

    public void chooseBook(String book) { // Add book in a array name " booksHistory"
        booksHistory.add(book);
    }

    public void displayChosenBooks() { // display which student choose which which book
        System.out.println("Books chosen by " + name + ":");
        for (String book : booksHistory) {
            System.out.println("- " + book);
        }
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
            System.out.println(" ");
            System.out.print("Enter Your Wish : ");
            int choice = sc.nextInt();

            if (choice == 0) { // Exit condition for the infinite loop
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println(" ");
                    System.out.print("How many students want to make ID : ");
                    size = sc.nextInt();

                    for (int j = 0; j < size; j++) {
                        System.out.println(" ");
                        System.out.print("Name : ");
                        String name = sc.next();

                        int studentID = random.nextInt(89999) + 10000;

                        System.out.print("Roll Number : ");
                        String rollNumber = sc.next();

                        System.out.print("Stream : ");
                        String stream = sc.next();

                        System.out.println();
                        students[j] = new Student(name, studentID, rollNumber, stream);

                        System.out.print("How many book " + name + " want to take : ");
                        int totalBooks = sc.nextInt();

                        for (int k = 0; k < totalBooks; k++) {
                            System.out.print("Enter " + "[ " + (k + 1) + " ] Book name : ");
                            String book = sc.next();
                            students[j].chooseBook(book); // mind that "choosBook" is function and "booksHistory" is a
                                                          // list or array
                        } // where store book name
                    }
                    break;

                case 2:
                System.out.print("Enter student name for Searching : ");
                targetStudent = sc.next();
                index = nameSearching(students, size, targetStudent);

                if (index != -1) {
                    System.out.print("Enter New Name (press 0 to keep it unchanged): ");
                    String newName = sc.next();
                    if (!newName.equals("0")) {
                        students[index].setName(newName);
                    }

                    System.out.print("Enter New Student ID (press 0 to keep it unchanged): ");
                    int updateStudentID = sc.nextInt();
                    if (updateStudentID != 0) {
                        students[index].setStudentID(updateStudentID);
                    }

                    System.out.print("Enter New Roll Number (press 0 to keep it unchanged): ");
                    String updateRollNumber = sc.next();
                    if (!updateRollNumber.equals("0")) {
                        students[index].setRollNumber(updateRollNumber);
                    }

                    System.out.print("Enter New Stream (press 0 to keep it unchanged): ");
                    String updateStream = sc.next();
                    if (!updateStream.equals("0")) {
                        students[index].setStream(updateStream);
                    }
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
                        System.out.println(" ");
                        students[index].displayChosenBooks();
                        System.out.println(" ");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        // Always close Scanner object
        sc.close();
    }
}
