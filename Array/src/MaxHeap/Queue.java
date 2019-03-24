package MaxHeap;

/**
 * Created by Administrator on 2019/1/30.
 */
public interface Queue<E> {
    int getSize();//队列大小
    boolean isEmpty();//队列是否为空
    void enqueue(E e);//入队列
    E dequeue();//出队列
    E getFront();//队列头元素
}
