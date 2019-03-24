package Map;

import LinkList.LinkedList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/17.
 */
public class Main {
    private static double testMap(Map<String,Integer>map,String  filename){
        long startTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if (FileOperation.readFile(filename,words)){
            System.out.println("Total words:"+words.size());

            for (String word:words){
                if (map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            }

            System.out.println("Total different words:"+map.getSize());
            System.out.println("Frequency of RRIDE:"+map.get("pride"));
            System.out.println("Frequency of PRIEJUDICE"+map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        return (endTime -startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        String  filename = "pride-and-prejudice.txt";

        BSTMap<String,Integer>bstMap = new BSTMap<String, Integer>();
        double time1 = testMap(bstMap,filename);
        System.out.println("BST Map:"+time1+"s");

        System.out.println();

        LinkedListMap<String,Integer>linkedListMap = new LinkedListMap<String, Integer>();
        double time2 = testMap(linkedListMap,filename);
        System.out.println("linkedListMap Map:"+time2+"s");

        System.out.println();
        LinkedListMapByCQ<String,Integer>cqMap = new LinkedListMapByCQ<String, Integer>();
        double time3 = testMap(cqMap,filename);
        System.out.println("LinkedListMapByCQ Map:"+time3+"s");

        System.out.println();

        AVLMap<String ,Integer> avlMap = new AVLMap<String, Integer>();
        double time4 = testMap(avlMap,filename);
        System.out.println("AVL Map:"+time4+"s");
    }
}
