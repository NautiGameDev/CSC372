import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Program
{
    public static void main(String[] args)
    {
        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner userInput = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("\nCSC372 Module 8 Portfolio Project");
        System.out.println("  by Chris Russell\n");

        while (isRunning)
        {
            System.out.println("\nEnter a coresponding number to navigate through the program.");
            System.out.println("  1. View student list");
            System.out.println("  2. Add new student");
            System.out.println("  3. Save list to .txt file");
            System.out.println("  4. Close program");

            
            System.out.print("\n >> ");
            String userSelection = userInput.nextLine();

            switch (userSelection)
            {
                case "1":
                    DisplayStudentData(studentList);
                    break;
                case "2":
                    AddNewStudent(userInput, studentList);
                    break;
                case "3":
                    SaveToTextFile(studentList, userInput);
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nPlease enter a valid input.");
                    break;
            }
        }

        userInput.close();
        System.out.println("\nClosing program. Thank you...");
    }

    public static void DisplayStudentData(LinkedList<Student> studentList)
    {
        if (studentList.isEmpty())
        {
            System.out.println("\nThe list is empty. Please add a student to view student data.");
        }
        else
        {
            SortListAlphabetically(studentList);
            System.out.println(""); //Used for spacing

            for (Student student : studentList)
            {
                System.out.println(student.GetStudentInformation());
            }
        }   
    }

    public static void AddNewStudent(Scanner userInput, LinkedList<Student> studentList)
    {
        System.out.println("\nAdding new student...");

        System.out.print("\n+ Student Name: ");
        String studentName = userInput.nextLine();

        System.out.print("\n+ Student Address: ");
        String studentAddress = userInput.nextLine();

        boolean isValid = false;
        double studentGPA = 0.0;

        //Use while loop to ensure user input is a valid number
        while(!isValid)
        {
            System.out.print("\n+ Student GPA: ");
            
            if(userInput.hasNextDouble())
            {
                studentGPA = userInput.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("\nPlease enter a valid number to continue...");
            }
        }

        Student newStudent = new Student(studentName, studentAddress, studentGPA);
        studentList.add(newStudent);

        userInput.nextLine();
    }

    public static void SortListAlphabetically(LinkedList<Student> studentList)
    {
        //Call comparator class to sort studentList alphabetically
        Collections.sort(studentList, new NameComparator());
        Iterator iterator = studentList.iterator();

        while(iterator.hasNext())
        {
            Student student = (Student)iterator.next();
        }
    }

    public static void SaveToTextFile(LinkedList<Student> studentList, Scanner userInput)
    {
        SortListAlphabetically(studentList);

        System.out.print("\nEnter a file name: ");
        String fileName = userInput.nextLine().strip();

        //Ensure last 4 characters is equal to ".txt" to prevent exceptions
        String lastFourChars = "";

        for (int i=fileName.length()-4; i<(fileName.length()); i++)
        {
            lastFourChars += fileName.charAt(i);
        }

        if (!lastFourChars.equalsIgnoreCase(".txt"))
        {
            fileName += ".txt";
        }

        //Save student data to txt file
        try
        {
            File myFile = new File(fileName);
            myFile.createNewFile();

            FileWriter fileWriter = new FileWriter(fileName);
            
            for (Student student : studentList)
            {
                fileWriter.write(student.GetStudentInformation() + "\n");
            }

            fileWriter.close();

            System.out.println("\nStudent data successfully saved to " + fileName);
        }
        catch (Exception exception)
        {
            System.out.println("\nThere was an error saving student data to " + fileName);
        }        
    }

    
}