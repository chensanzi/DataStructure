package Array;

/**
 * Created by Administrator on 2019/1/28.
 */
public class Student {
    private String name;
    private int score;

    public Student(String studentName,int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString(){
        return String.format("Array.Student(name: %s,score:%d)",name,score);
    }

    public static void main(String[] args) {
//        Array<Student> array = new Array();
//        array.addLast(new Student("Alice",100));
//        array.addLast(new Student("Bob",66));
//        array.addLast(new Student("Charlie",88));
//        System.out.println(array.toString());

        ArrayByCQ<Student> array1 = new ArrayByCQ();
        array1.addLast(new Student("Alice",100));
        array1.addLast(new Student("Bob",66));
        array1.addLast(new Student("Charlie",88));
        System.out.println(array1.toString());
    }
}
