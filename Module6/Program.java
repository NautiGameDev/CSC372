import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Chris Russell
 * January 25, 2025
 * Module 6 Critical Thinking Option 1
 * Programming II CSC372
 */

public class Program
{
    public static void main(String[] args)
    {
        int numberOfStudents = 10;
        ArrayList<Student> studentArray = BuildStudentArrayList(numberOfStudents); //Calls method that utilizes generator class to build array list

        boolean isRunning = true;
        Scanner userInput = new Scanner(System.in);

        while(isRunning)
        {
            System.out.println("\nEnter the number of a command to select an action, or enter Q to quit.");
            System.out.println("    1. Sort student list alphabetically");
            System.out.println("    2. Sort student list by roll number");

            System.out.print("\n\n >> ");
            String userCommand = userInput.nextLine();

            switch(userCommand)
            {
                case "q": case "Q":
                    isRunning = false;
                    break;
                case "1":
                    SortAlphabetically(studentArray);
                    break;
                case "2":
                    SortNumerically(studentArray);
                    break;
                default:
                    System.out.println("Command invalid. Please enter a valid command.");
                    break;
            }
            
        }

        System.out.println("Closing program...");
        userInput.close();
    }

    public static ArrayList<Student> BuildStudentArrayList(int numberOfStudents)
    {
        /*
         * Generates an ArrayList of student objects with name, roll number, and addresses, then returns to main program.
         * Program uses custom DataGenerator class with static methods to generate student information. 
        */

        ArrayList<Student> studentArray = new ArrayList<>();

        System.out.println("Generating student data...");

        for (int i=0; i<numberOfStudents; i++)
        {
            String studentName = DataGenerator.GenerateStudentName();
            String studentAddress = DataGenerator.GenerateAddress();
            int studentRollNo = DataGenerator.GenerateRollNumber();

            Student student = new Student(studentRollNo, studentName, studentAddress);
            studentArray.add(student);

            System.out.println("\nStudent successfully generated");
            System.out.println("  + Name: " + studentName);
            System.out.println("  + Address: " + studentAddress);
            System.out.println("  + Roll Number: " + studentRollNo);
        }

        return studentArray;
    }

    public static void SortAlphabetically(ArrayList<Student> studentArray)
    {
        System.out.println("\nSorting student data alphabetically");
        System.out.println("\nRoll Number | Name | Address");

        Collections.sort(studentArray, new NameComparator());
        Iterator iterator = studentArray.iterator();

        while(iterator.hasNext())
        {
            Student student = (Student)iterator.next();
            System.out.println(student.rollno + " | " + student.name + " | " + student.address);
        }
    }

    public static void SortNumerically(ArrayList<Student> studentArray)
    {
        System.out.println("\nSorting student data by roll number");
        System.out.println("\nRoll Number | Name | Address");

        Collections.sort(studentArray, new NumberComparator());
        Iterator iterator = studentArray.iterator();

        while(iterator.hasNext())
        {
            Student student = (Student)iterator.next();
            System.out.println(student.rollno + " | " + student.name + " | " + student.address);
        }
    }
}