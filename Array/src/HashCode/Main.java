package HashCode;

/**
 * Created by Administrator on 2019/3/12.
 */
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3,2,"BOBO","Liu");
        Student student2 = new Student(3,2,"BOBO","Liu");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<Student>();
        set.add(student);

        System.out.println(set.contains(student));
        System.out.println(set.contains(student2));

        System.out.println(student.equals(student2));

//        HashMap<Student,Integer> scores = new HashMap<Student, Integer>();
//        scores.put(student,100);
//
//        //如果自定义的类中没有重写hashcode方法，那么使用的是java Object对象对应的hashcode方法，
//        // 指向的是对象的地址
//        Student student2 = new Student(3,2,"BOBO","Liu");
//        System.out.println(student2.hashCode());
    }
}
