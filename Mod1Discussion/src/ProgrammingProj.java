import java.util.Map;

class ProgrammingProj extends Project {
    String projectLanguage;
    String projectFramework;

    public ProgrammingProj(String projectName, String projectDescription, String creationDate, String dueDate, String projectLanguage, String projectFramework)
    {
        super(projectName, projectDescription, creationDate, dueDate);
        this.projectLanguage = projectLanguage;
        this.projectFramework = projectFramework;
    }

    @Override
    public Map<String, String> GetProjectInformation()
    {
        Map<String, String> projectInformation = super.GetProjectInformation();
        projectInformation.put("Language", projectLanguage);
        projectInformation.put("Framework", projectFramework);
        return projectInformation;
    }
}
