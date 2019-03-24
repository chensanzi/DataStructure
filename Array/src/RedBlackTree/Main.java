package RedBlackTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2019/3/2.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)){

            Collections.sort(words);

            //Test BST
            long startTime = System.nanoTime();
            BST<String,Integer> bst = new BST<String, Integer>();
            for (String word:words){
                if (bst.contains(word)){
                    bst.set(word,bst.get(word)+1);
                }else {
                    bst.add(word,1);
                }
            }

            for (String word:words){
                bst.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime-startTime)/1000000000.0;
            System.out.println("BST:"+time+"s");

            //Test AVLTree
            startTime = System.nanoTime();
            AVLTree<String,Integer> avlTree = new AVLTree<String, Integer>();
            for (String word:words){
                if (avlTree.contains(word)){
                    avlTree.set(word,bst.get(word)+1);
                }else {
                    avlTree.add(word,1);
                }
            }

            for (String word:words){
                avlTree.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime-startTime)/1000000000.0;
            System.out.println("AVLTree:"+time+"s");
        }

        //Test RBTree
        long startTime = System.nanoTime();
        RBTree<String,Integer> rbTree = new RBTree<String, Integer>();
        for (String word:words){
            if (rbTree.contains(word)){
                rbTree.set(word,rbTree.get(word)+1);
            }else {
                rbTree.add(word,1);
            }
        }

        for (String word:words){
            rbTree.contains(word);
        }
        long endTime = System.nanoTime();
        double time = (endTime-startTime)/1000000000.0;
        System.out.println("RBTree:"+time+"s");

    }
}
