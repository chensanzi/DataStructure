package MaxHeap;

/**
 * Created by Administrator on 2019/2/27.
 */
public class PriorityQueueByCQ<E extends Comparable<E>> implements Queue<E>{

    private MaxHeapByCQ<E> heap;

    public PriorityQueueByCQ(){
        heap = new MaxHeapByCQ();
    }

    @Override
    public int getSize(){
        return heap.getSize();
    }

    @Override
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    @Override
    public E getFront(){
        return heap.findMax();
    }

    @Override
    public void enqueue(E e){
        heap.add(e);
    }

    @Override
    public E dequeue(){
        return heap.extrcMax();
    }
}
