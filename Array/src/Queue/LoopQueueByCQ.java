package Queue;

import Array.Array;

/**
 * Created by Administrator on 2019/2/18.
 */
public class LoopQueueByCQ<E> implements Queue<E>{
    private int fornt;
    private int tail;
    private int size;
    private E[] data;

    public LoopQueueByCQ(){
        data = (E[]) new Object[10];
        fornt = tail = 0;
        size = 0;
    }

    public LoopQueueByCQ(int capacity){
        data = (E[]) new Object[capacity+1];
        size = 0;
        fornt = tail =0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public void enqueue(E e){
        //表示队列为空
       if ((tail+1)%data.length == fornt){
           //扩容
           resize(getCapacity()*2);
       }

        data[tail] = e;
        tail = (tail +1)%data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }

        E ret = data[fornt];
        data[fornt] = null;

        //缩容
        if (size<getCapacity()/4&&getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }

        fornt = (fornt+1)%data.length;
        size--;
        return ret;
    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[fornt];
    }

    //扩容函数
    private void resize(int newCapacity){
        E[] newdata = (E[]) new Object[newCapacity+1];

        for (int i=0;i<size;i++){
            newdata[i] = data[(fornt+i)%data.length];
        }
        tail = size;
        fornt = 0;
        data = newdata;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue size:%d,capacity:%d\n",size,getCapacity()));
        str.append("fornt:[");
        for (int i= fornt;i != tail;i=(i+1)%data.length){
            str.append(data[i]);
            if ((i+1)%data.length != tail){
                str.append(",");
            }
        }
        str.append("]tail");
        return str.toString();
    }

    public static void main(String[] args) {
        LoopQueueByCQ<Integer> queue = new LoopQueueByCQ<Integer>(3);
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3==0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
//        System.out.println(queue.toString());
    }
}
