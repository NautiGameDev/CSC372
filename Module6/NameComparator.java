import java.util.Comparator;

public class NameComparator implements Comparator
{
    @Override
    public int compare(Object s1, Object s2)
    {
        Student student1 = (Student)s1;
        Student student2 = (Student)s2;

        return student1.name.compareTo(student2.name);
    }
}
