public class Student {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA)
    {
        this.name = name;
        this.address = address;
        this.GPA = GPA;

        System.out.println("\nStudent " + name + " has been added.");
    }

    public String GetName()
    {
        return name;
    }

    public String GetStudentInformation()
    {
        return "Name: " + name + " || Address: " + address + " || GPA: " + GPA;
    }
}
