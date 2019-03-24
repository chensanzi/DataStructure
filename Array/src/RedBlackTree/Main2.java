package RedBlackTree;

import Map.AVLMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2019/3/3.
 */
public class Main2 {
    public static void main(String[] args) {
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //Test BST
        long startTime = System.nanoTime();

        BST<Integer,Integer> bst = new BST<Integer, Integer>();
        for (Integer x:testData){
            bst.add(x,null);
        }

        long endTime = System.nanoTime();

        double time = (endTime -startTime)/1000000000.0;
        System.out.println("BST:"+time+"s");

        //Test AVL
        startTime = System.nanoTime();

        AVLMap<Integer,Integer> avlMap = new AVLMap<Integer, Integer>();
        for (Integer x:testData){
            avlMap.add(x,null);
        }

        endTime = System.nanoTime();

        time = (endTime -startTime)/1000000000.0;
        System.out.println("avlMap:"+time+"s");

        //Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer,Integer> rbTree = new RBTree<Integer, Integer>();
        for (Integer x:testData){
            rbTree.add(x,null);
        }

        endTime = System.nanoTime();

        time = (endTime -startTime)/1000000000.0;
        System.out.println("rbTree:"+time+"s");
    }
}
