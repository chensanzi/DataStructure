package MaxHeap;

import java.util.Random;

/**
 * Created by Administrator on 2019/2/26.
 */
public class MaxHeapByCQ<E extends Comparable<E>> {
    private Array<E> data;


    public MaxHeapByCQ(){
        data = new Array<E>();
    }

    public MaxHeapByCQ(int capacity){
        data = new Array<E>(capacity);
    }

    public MaxHeapByCQ(E[] arr){
        data = new Array<E>(arr);
        for (int i = parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int parent(int index){
        if (index==0){
            throw new IllegalArgumentException("this is frist element");
        }
        return (index-1)/2;
    }

    public int leftChild(int index){
//        if (index*2+1<data.getSize()-1){
//            return index*2+1;
//        }else{
//            throw new IllegalArgumentException("dont have leftChilde");
//        }
        return index*2+1;
    }

    public int rightChild(int index){
//        if (index*2+2<data.getSize()-1){
//            return index*2+2;
//        }else{
//            throw new IllegalArgumentException("dont have rightChild");
//        }
        return index*2+2;
    }

    //添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    public void siftUp(int k){
        while(k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if (rightChild(k)<data.getSize() && data.get(rightChild(k)).compareTo(data.get(leftChild(k)))>0){
                j = j+1;
            }

            if (data.get(k).compareTo(data.get(j))>0){
                break;
            }

            data.swap(k,j);
            k = j;
        }
    }

    public E findMax(){
        if (isEmpty()){
            throw new IllegalArgumentException("this heap is empty");
        }
        return data.getFirst();
    }

    public E extrcMax(){
        if (isEmpty()){
            throw new IllegalArgumentException("this heap is empty");
        }
        E ret = findMax();

        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
//        int num = 10;
//        Random random = new Random();
//        MaxHeapByCQ<Integer> maxHeapByCQ = new MaxHeapByCQ();
//        for (int i=0;i<num;i++){
//            maxHeapByCQ.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        Array<Integer> array = new Array();
//        for (int i=0;i<num;i++){
//            array.addLast(maxHeapByCQ.extrcMax());
//        }
//
//        for (int i=0;i<array.getSize()-1;i++){
//            if (array.get(i)<array.get(i+1)){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//
//        System.out.println("Test is success");
        int n = 1000000;
        Random random = new Random();
        Integer[] a = new Integer[n];
        for (int i=0;i<n;i++){
            a[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxHeapByCQ<Integer> heap = new MaxHeapByCQ<Integer>();
        System.out.println("flag=true time:"+heap.timeTest(a,true));
        System.out.println("flag=false time:"+heap.timeTest(a,false));
    }

    private double timeTest(E[] arr,boolean flag){
        long startTime = System.nanoTime();
        if (flag){
            MaxHeapByCQ<E> heap = new MaxHeapByCQ<E>(arr);
            Array<E> array = new Array();
                for (int i=0;i<arr.length;i++){
                    array.addLast(heap.extrcMax());
                }

                for (int i=0;i<array.getSize()-1;i++){
                    if (array.get(i).compareTo(array.get(i+1))<0){
                        throw new IllegalArgumentException("Error");
                    }
                }
            }else{
            MaxHeapByCQ<E> heap = new MaxHeapByCQ<E>();
            Array<E> array = new Array();
            for (int i=0;i<arr.length;i++){
                heap.add(arr[i]);
            }

            for (int i=0;i<arr.length;i++){
                array.addLast(heap.extrcMax());
            }

            for (int i=0;i<array.getSize()-1;i++){
                if (array.get(i).compareTo(array.get(i+1))<0){
                    throw new IllegalArgumentException("Error");
                }
            }
        }

        long endTime = System.nanoTime();
        return (endTime-startTime)/100000000.0;
    }

    private static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap = new MaxHeap<Integer>(testData);
        }else {
            maxHeap = new MaxHeap<Integer>();
            for (int num:testData){
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i=0;i<testData.length;i++){
            arr[i] = maxHeap.extractMax();
        }

        for (int i=1;i<testData.length;i++){
            if (arr[i-1]<arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed");
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
