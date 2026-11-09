package classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class classwork12 {
    public static void main(String[] args) {
        // Create an ArrayList for students
        List<String> students = new ArrayList<>();

        // Add initial student names to the list
        students.add("Vasya");
        students.add("Petya");
        students.add("Volodya");
        students.add("Diana");
        students.add("Dima");
        students.add("Taras");

        // Print all names to the console
        System.out.println("Initial students list: " + students);


        // Add one more name to the end of the list
        students.add("Polina");
        System.out.println("After adding to the end: " + students);

        // Insert one name at index 2
        students.add(2, "Anna");
        System.out.println("After inserting at index 2: " + students);

        // Replace the student at index 4 with a new name
        students.set(4, "Ivan");
        System.out.println("After replacing at index 4: " + students);

        // Remove one student by name
        students.remove("Petya");
        System.out.println("After removing Petya: " + students);

        // Setup scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a name from the console
        System.out.print("Enter a student name to search: ");
        String searchName = scanner.nextLine();

        // Check if that name exists using contains method
        if (students.contains(searchName)) {
            // If it exists print the index position
            int index = students.indexOf(searchName);
            System.out.println("Found at index " + index);
        } else {
            // Otherwise print student not found message
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}