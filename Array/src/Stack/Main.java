package Stack;

import java.util.Random;

/**
 * Created by Administrator on 2019/1/30.
 */
public class Main {
//    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<Integer>();
//
//        for (int i = 0 ;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);
//
//
//    }

    private static double testStack(Stack<Integer>stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<opCount;i++){
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

//    public static void main(String[] args) {
//       int opCount = 10000000;
//
//        ArrayStack<Integer>arrayStack = new ArrayStack<Integer>();
//        double time1 = testStack(arrayStack,opCount);
//        System.out.println("ArrayStack,time:"+time1+"s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
//        double time2 = testStack(linkedListStack,opCount);
//        System.out.println("LinkedListStack,time:"+time2+"s");
//
//        //其实这个时间比较很复杂，因为ArrayListStack中有动态扩容，而linkedListStack中包含了很多new的操作
//    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStackByCQ<Integer>arrayStack = new ArrayStackByCQ<Integer>();
        for (int i=0;i<6;i++){
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }

        for (int i=0;i<6;i++){
            arrayStack.pop();
            System.out.println(arrayStack.toString());
        }

        System.out.println("----------------------------------------------------------");

        ArrayStack<Integer>arrayStack1 = new ArrayStack<Integer>();
        for (int i=0;i<6;i++){
            arrayStack1.push(i);
            System.out.println(arrayStack1.toString());
        }

        for (int i=0;i<6;i++){
            arrayStack1.pop();
            System.out.println(arrayStack1.toString());
        }

    }
}
