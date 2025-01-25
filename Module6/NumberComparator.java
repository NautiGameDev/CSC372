import java.util.Comparator;

public class NumberComparator implements Comparator
{
    @Override
    public int compare(Object s1, Object s2)
    {
        Student student1 = (Student)s1;
        Student student2 = (Student)s2;

        Integer s1RollNo = student1.rollno;
        Integer s2RollNo = student2.rollno;

        return s1RollNo.compareTo(s2RollNo);
    }
}