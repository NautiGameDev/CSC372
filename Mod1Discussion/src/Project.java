import java.util.LinkedHashMap;
import java.util.Map;

public class Project {
    String projectName;
    String projectDescription;
    String creationDate;
    String dueDate;

    public Project(String projectName, String projectDescription, String creationDate, String dueDate)
    {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public Map<String, String> GetProjectInformation()
    {
        Map<String, String> projectInformation = new LinkedHashMap<>();
        projectInformation.put("Name", projectName);
        projectInformation.put("Description", projectDescription);
        projectInformation.put("Creation Date", creationDate);
        projectInformation.put("Due Date", dueDate);
        return projectInformation;
    }
}
