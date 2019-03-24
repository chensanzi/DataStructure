package Solution;


import MaxHeap.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Administrator on 2019/2/27.
 *
 */
public class LeetCode_347ByCQ<E> {
    private class Freq implements Comparable<Freq> {
        private E e;
        private int freq;

        public Freq(E e,int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if (this.freq<another.freq){
                return 1;
            }else if(this.freq>another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public List<E> topKFrequence(E[] arrs,int k){
        TreeMap<E,Freq> map = new TreeMap<E, Freq>();
        for (E arr:arrs){
            if (!map.containsKey(arr)){
                map.put(arr,new Freq(arr,1));
            }else {
                map.put(arr,new Freq(arr,map.get(arr).freq+1));
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue();
        for (E e:map.keySet()) {
            if (queue.getSize()<k){
                queue.enqueue(map.get(e));
            }else{
                if (map.get(e).freq>queue.getFront().freq){
                    queue.dequeue();
                    queue.enqueue(map.get(e));
                }
            }
        }

        List<E> list = new ArrayList<E>();
        for (int i=0;i<k;i++){
            list.add(queue.dequeue().e);
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
        List list = new LeetCode_347ByCQ().topKFrequence(arr,2);
        printList(list);
    }
}
