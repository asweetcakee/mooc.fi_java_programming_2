
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MainProgram {

    public static void main(String[] args) {
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        Student third = new Student("jam");
        List<Student> students = new ArrayList<>();
        students.add(first);
        students.add(second);
        students.add(third);
        Collections.sort(students, (s1, s2) ->{
            return s1.getName().compareTo(s2.getName());
        });
        System.out.println(students);
        System.out.println(first.compareTo(second));
    }
}
