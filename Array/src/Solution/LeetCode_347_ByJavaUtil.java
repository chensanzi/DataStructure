package Solution;

import java.util.*;

/**
 * Created by Administrator on 2019/2/23.
 */
public class LeetCode_347_ByJavaUtil {
    private class Freq {
        Integer e,freq;

        public Freq(int e,int freq){
            this.e = e ;
            this.freq = freq;
        }

//        @Override
//        public int compareTo(Freq another){
//            if (this.freq < another.freq){
//                return -1;
//            }else if (this.freq>another.freq){
//                return 1;
//            }else {
//                return 0;
//            }
//        }
    }

    private class FreqComparator implements Comparator<Freq>{
        @Override
        public int compare(Freq a,Freq b){
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequence(int[] nums, int k){
        final TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for (int num:nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
//        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
        //匿名类
//        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new Comparator<Solution.LeetCode_347_ByJavaUtil.Freq>() {
//            @Override
//            public int compare(Freq a, Freq b) {
//                return a.freq - b.freq;
//            }
//        });

//        匿名类
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override//改变Integer的比较
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
//                (a,b) -> map.get(a)- map.get(b);
//        );

//        for (int key:map.keySet()){
//            if (pq.size()<k){
//                pq.add(new Freq(key,map.get(key)));
//            }else if (map.get(key) > pq.peek().freq){
//                pq.remove();
//                pq.add(new Freq(key,map.get(key)));
//            }
//        }
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<Integer>();
        while (!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
