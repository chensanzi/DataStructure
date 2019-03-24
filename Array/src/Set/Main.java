package Set;

import LinkList.*;
import Map.FileOperation;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/16.
 */
public class Main {
//    public static void main(String[] args) {
//        System.out.println("Pride and Prejudice");

//        ArrayList<String> words1 = new ArrayList<String>();
//        FileOperation.readFile("pride-and-prejudice.txt",words1);
//        System.out.println("Total words:"+words1.size());
//
//        BSTSet<String> set1 = new BSTSet(){};
//        for (String word:words1){
//            set1.add(word);
//        }
//        System.out.println("Total different words:"+set1.getSize());

//        ArrayList<String> words1 = new ArrayList<String>();
//        FileOperation.readFile("pride-and-prejudice.txt",words1);
//        System.out.println("Total words:"+words1.size());
//
//        LinkedListSetByCQ<String> set1 = new LinkedListSetByCQ(){};
//        for (String word:words1){
//            set1.add(word);
//        }
//        System.out.println("Total different words:"+set1.getSize());

//    }

    private static double testSet(Set<String>set,String filename){
        long startTime = System.nanoTime();
         // TODO
        ArrayList<String> words1 = new ArrayList<String>();
        FileOperation.readFile(filename,words1);
        System.out.println("Total words:"+words1.size());
        for (String word:words1){
            set.add(word);
        }
        System.out.println("Total different words:"+set.getSize());


        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<String>();
        double time1 = testSet(bstSet,filename);
        System.out.println("BST Set:"+time1+"s");

        System.out.println();

        LinkedListSetByCQ<String> linkedListSet = new LinkedListSetByCQ<String>();
        double time2 = testSet(linkedListSet,filename);
        System.out.println("linkedListSet Set:"+time2+"s");

        System.out.println();
        AVLSet<String> avl = new AVLSet<String>();
        double time3 = testSet(avl,filename);
        System.out.println("AVLSet Set:"+time3+"s");
    }
}
