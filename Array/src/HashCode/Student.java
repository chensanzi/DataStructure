package HashCode;

/**
 * Created by Administrator on 2019/3/12.
 */
public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade,int cls,String firstName,String lastName){
        this.grade = grade;
        this.cls = cls;
        this.firstName=firstName;
        this.lastName=lastName;
    }

//    @Override
//    public int hashCode(){
//        int B = 31;
//
//        int hash = 0;
//        hash = hash*B+grade;
//        hash = hash*B+cls;
//        hash = hash*B+firstName.toLowerCase().hashCode();//不区分大小写
//        hash = hash*B+lastName.toLowerCase().hashCode();//不区分大小写
//
//        return hash;
//    }

    @Override
    public boolean equals(Object o){

        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }

        Student another = (Student)o;

        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.equals(another.firstName)&&
                this.lastName.equals(another.lastName);
    }
}
