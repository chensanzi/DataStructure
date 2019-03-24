package Solution;

import Array.Array;

import java.util.*;

/**
 * Created by Administrator on 2019/2/27.
 */
public class LeetCode_347_ByJavaUtilCQ<E> {
    private class Freq<E>{
        private E e;
        private int freq;

        public Freq(E e,int freq){
            this.e=e;
            this.freq=freq;
        }
    }

    public List<E> topKFrequent(E[] arrs,int k){

        TreeMap<E,Integer> map = new TreeMap<E,Integer>();
        for (E arr:arrs){
           if (!map.containsKey(arr)){
               map.put(arr,1);
           }else {
               map.put(arr,map.get(arr)+1);
           }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<Freq>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
               return o1.freq -o2.freq;
            }
        });

        for (E key:map.keySet()){
            if (priorityQueue.size()<k){
                priorityQueue.add(new Freq(key,map.get(key)));
            }else {
                if (priorityQueue.peek().freq<map.get(key)){
                    priorityQueue.poll();
                    priorityQueue.add(new Freq(key,map.get(key)));
                }
            }
        }

        List<E> list = new ArrayList<E>();
       while(!priorityQueue.isEmpty()){
           list.add((E) priorityQueue.remove().e);
       }

       return list;
    }

    private static void printList(List nums){
//        for (E a:nums){
//
//        }
        for (int i=0;i<nums.size();i++){
            System.out.print(nums.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,1,2,2,3,4,4,4,4,4,3,3};
        List list = new LeetCode_347_ByJavaUtilCQ().topKFrequent(arr,2);
        printList(list);
    }
}
