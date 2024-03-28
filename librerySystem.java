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

    public boolean bookRemovel(String bookName) {
        return booksHistory.remove(bookName); // It returns "true" if the book was found and removed, and "false"
                                              // otherwise.
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
        System.out.println("2. Print All Student Name");
        System.out.println("3. Update Student Information");
        System.out.println("4. Book Removel");
        System.out.println("5. Display Student Profile");
        System.out.println("0. Exit");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Student[] students = new Student[1000];  //  " students " is the Array of object which is instance of class
                                                             //  so here array type is --> Class "Student"

        String targetStudent = "";
        int index = 0;
        int size = 0;

        optionDisplay();
        while (true) {
            System.out.println(" ");
            System.out.print("Enter Your Wish : ");
            int choice = sc.nextInt();

            if (choice == 0) { // Exit condition for the infinite loop { that use for Unreachable Code ---> reachable Code }
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println(" ");
                    System.out.print("How many students want to make ID : ");  // Taking total number of student
                    size = sc.nextInt();

                    for (int j = 0; j < size; j++) {
                        System.out.println(" ");
                        System.out.print("Name : "); // User Input
                        String name = sc.next();

                        int studentID = random.nextInt(89999) + 10000;  // Create Student ID using Random number

                        System.out.print("Roll Number : "); // User Input
                        String rollNumber = sc.next();

                        System.out.print("Stream : ");  // User Input
                        String stream = sc.next();

                        System.out.println();
                        students[j] = new Student(name, studentID, rollNumber, stream);// " new Student(name, studentID, rollNumber, stream); " this is object of Class name " Student "
                                                                                       // Every user Input data create a new Object and store Index wise in the array name " students "

                        System.out.print("How many book " + name + " want to take : "); // User input ---> total number of Book
                        int totalBooks = sc.nextInt();

                        for (int k = 0; k < totalBooks; k++) {
                            System.out.print("Enter " + "[ " + (k + 1) + " ] Book name : ");
                            String book = sc.next();
                            students[j].chooseBook(book); // Remember that "choosBook" is function and "booksHistory" is a list or array  where store book name
                        }
                    }
                    break;

                case 2:
                    System.out.println(" ");
                    for (int m = 0; m < size; m++) {
                        System.out.println((m+1)+" ) Name : " + students[m].getName());     // This case 2 is used for print ALL student name
                    }
                    System.out.println(" ");
                    break;

                case 3:
                    System.out.print("Enter student name for Searching : "); // User Input
                    targetStudent = sc.next();
                    index = nameSearching(students, size, targetStudent);  // Function call for get specific Student Index 

                    if (index != -1) {   // Check target student is got or not in Index
                        System.out.println("**press 0 to keep it unchanged** ");
                        System.out.print("Enter New Name : ");   // User Input
                        String newName = sc.next();
                        if (!newName.equals("0")) {     // check Input is Zero or not.
                            students[index].setName(newName);
                        }

                        System.out.print("Enter New Student ID : ");   // User Input
                        int updateStudentID = sc.nextInt();
                        if (updateStudentID != 0) {     // check Input is Zero or not.
                            students[index].setStudentID(updateStudentID);
                        }

                        System.out.print("Enter New Roll Number : ");   // User Input
                        String updateRollNumber = sc.next();
                        if (!updateRollNumber.equals("0")) {     // check Input is Zero or not.
                            students[index].setRollNumber(updateRollNumber);
                        }

                        System.out.print("Enter New Stream : ");   // User Input
                        String updateStream = sc.next();
                        if (!updateStream.equals("0")) {     // check Input is Zero or not.
                            students[index].setStream(updateStream);
                        }
                    }
                    break;

                case 4:
                    System.out.println(" ");
                    System.out.print("Enter student name for Searching : "); // User Input
                    targetStudent = sc.next();
                    index = nameSearching(students, size, targetStudent); // Function call for get specific Student Index 

                    if (index != -1) {    // Check target student is got or not in Index
                        System.out.print("Enter Book name for removel : ");
                        String bookName = sc.next();
                        boolean check_Remove_Or_Not = students[index].bookRemovel(bookName); // check that book is removed or not. if removed " check_Remove_Or_Not " ---> true
                                                                                                                                                            //neither ---> false
                        if (check_Remove_Or_Not) {
                            System.out.println(bookName + " Removed Successfully from " + students[index].getName() + "'s account");
                        } else {
                            System.out.println(bookName + " Book Not found from " + students[index].getName() + "'s account");
                        }
                    } else {
                        System.out.println();
                    }
                    System.out.println(" ");
                    break;

                case 5:
                    System.out.print("Enter student name for Searching : ");
                    targetStudent = sc.next();
                    index = nameSearching(students, size, targetStudent);

                    if (index != -1) {
                        System.out.println("Name: " + students[index].getName());              // Display Profile of Specific student
                        System.out.println("Student ID: " + students[index].getStudentID());
                        System.out.println("Roll Number: " + students[index].getRollNumber());
                        System.out.println("Stream: " + students[index].getStream());
                        System.out.println(" ");
                        students[index].displayChosenBooks();  // Display Books of Specific student
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
