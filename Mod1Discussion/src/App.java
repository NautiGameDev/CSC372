import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        HashMap<String, Project> projects;
        Scanner userInput;

        projects = new HashMap<>();
        userInput = new Scanner(System.in);

        boolean isRunning = true;

        while(isRunning)
        {
            System.out.println("\n\nWhat type of project would you like to create?");
            System.out.println("1. General Project\n2. Programming Project");
            
            if (userInput.hasNextInt())
            {
                int userChoice = userInput.nextInt();
                userInput.nextLine();

                switch(userChoice)
                {
                    case 1:
                        CreateProject(userInput, projects);
                        break;
                    case 2:
                        CreateProgrammingProject(userInput, projects);
                        break;
                }
            }
            else
            {
                System.out.println("Please enter a number to select a project type.");
                userInput.next();
            }            
        }

        userInput.close();
    }

    public static void CreateProject(Scanner userInput, HashMap<String, Project> projects)
    {
        System.out.println("Enter the following items for your project: [Name, Description, Due Date]");
        
        String projectCreationDate = java.time.LocalDateTime.now().toString();

        Project newProject = new Project(userInput.nextLine(),
         userInput.nextLine(), projectCreationDate, userInput.nextLine());
        
        Map<String, String> projectInformation = newProject.GetProjectInformation();
        projects.put(projectInformation.get("Name"), newProject);
        
        System.out.println("\n\nProject Created:");
        for (String str : projectInformation.keySet())
        {
            System.out.println(str + ": " + projectInformation.get(str));
        }
    }

    public static void CreateProgrammingProject(Scanner userInput, HashMap<String, Project> projects)
    {
        System.out.print("Enter the following items for your project:");
        System.out.println("[Name, Description, Due Date, Programming Language, Programming Framework]");

        String projectCreationDate = java.time.LocalDateTime.now().toString();

        ProgrammingProj newProject = new ProgrammingProj(userInput.nextLine(), userInput.nextLine(), 
        projectCreationDate, userInput.nextLine(), userInput.nextLine(), userInput.nextLine());
        
        Map<String, String> projectInformation = newProject.GetProjectInformation();
        projects.put(projectInformation.get("Name"), newProject);
        
        System.out.println("\n\nProject Created:");
        for (String str : projectInformation.keySet())
        {
            System.out.println(str + ": " + projectInformation.get(str));
        }
    }
}