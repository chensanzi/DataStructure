package Solution;

import Array.Array;

/**
 * Created by Administrator on 2019/2/18.
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。

 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

 你的实现应该支持如下操作：

 MyCircularQueue(k): 构造器，设置队列长度为 k 。
 Front: 从队首获取元素。如果队列为空，返回 -1 。
 Rear: 获取队尾元素。如果队列为空，返回 -1 。
 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 isEmpty(): 检查循环队列是否为空。
 isFull(): 检查循环队列是否已满。
 */
public class LeetCode_622 {

    private int[] queue;
    private int front;
    private int tail;
    private int size;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public LeetCode_622(int k) {
        queue = new int[k+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }

        queue[tail] = value;
        tail = (tail+1)%queue.length;
        try {
            size++;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        queue[front] = 0;
        front = (front+1)%queue.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        int i = (queue.length+tail-1)%queue.length;
        int ret = queue[i];
        return ret;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length-1;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("queue size:%d;capacity:%d\n",size,queue.length));
        str.append("front:[");
        for (int i= front;i!=tail;i=(i+1)%queue.length){
            str.append(queue[i]);
            if (i != tail-1){
                str.append(",");
            }
        }
        str.append("]tail");
        return str.toString();
    }

    public static void main(String[] args) {
//        LeetCode_622 queue = new LeetCode_622(10);
//        for (int i=0;i<12;i++){
//            queue.enQueue(i);
//            System.out.println(queue);
//
//            if (i%3==1){
//                queue.deQueue();
//                System.out.println(queue);
//            }
//        }
//        ["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//        [[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        LeetCode_622 queue = new LeetCode_622(6);
        queue.enQueue(6); System.out.println(queue);
        System.out.println(queue.Rear());System.out.println(queue);
        System.out.println(queue.Rear());System.out.println(queue);
        queue.deQueue(); System.out.println(queue);
        queue.enQueue(5); System.out.println(queue);
        System.out.println(queue.Rear());System.out.println(queue);
        queue.deQueue(); System.out.println(queue);
        System.out.println(queue.Front());System.out.println(queue);
        queue.deQueue(); System.out.println(queue);
        queue.deQueue(); System.out.println(queue);
        queue.deQueue(); System.out.println(queue);



        queue.enQueue(2); System.out.println(queue);
        queue.enQueue(3); System.out.println(queue);
        queue.enQueue(4); System.out.println(queue);
        System.out.println(queue.Rear());System.out.println(queue);
        System.out.println(queue.isFull()); System.out.println(queue);
        queue.deQueue(); System.out.println(queue);
        queue.enQueue(4); System.out.println(queue);
        System.out.println(queue.Rear());System.out.println(queue);
    }
}
