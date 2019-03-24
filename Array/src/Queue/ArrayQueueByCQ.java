package Queue;

import Array.ArrayByCQ;

/**
 * Created by Administrator on 2019/2/15.
 */
public class ArrayQueueByCQ<E> implements Queue<E>{
    private ArrayByCQ<E> arrayQuque;

    public ArrayQueueByCQ(int capacity){
        arrayQuque = new ArrayByCQ<E>(capacity);
    }

    public ArrayQueueByCQ(){
        arrayQuque = new ArrayByCQ<E>();
    }

    @Override
    public int getSize(){
        return arrayQuque.getSize();
    }

    @Override
    public void enqueue(E e){
        arrayQuque.addLast(e);
    }

    @Override
    public E dequeue(){
        return arrayQuque.removeFirst();
    }

    @Override
    public E getFront(){
        return arrayQuque.get(0);
    }

    @Override
    public boolean isEmpty(){
        return arrayQuque.isEmpty();
    }

    public int getCapacity(){
        return arrayQuque.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Queue front[");
        for (int i=0;i<arrayQuque.getSize();i++){
            str.append(arrayQuque.get(i));
            if (i != arrayQuque.getSize()-1){
                str.append(",");
            }
        }
        str.append("]tail");
        return str.toString();
    }

    public static void main(String[] args) {
        ArrayQueueByCQ<Integer> queue = new ArrayQueueByCQ<Integer>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==1){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
