import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    students.add(new Student(roll, name, age));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    System.out.println("\n--- Student List ---");
                    for (Student s : students) {
                        s.displayStudent();
                        System.out.println("--------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int r = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.rollNumber == r) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Bye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}