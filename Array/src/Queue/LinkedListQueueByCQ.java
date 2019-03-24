package Queue;



/**
 * Created by Administrator on 2019/2/15.
 */
public class LinkedListQueueByCQ<E> implements Queue<E>{

    private class Node{
        private Node next;
        private E e;

        public Node(Node next,E e){
            this.next = next;
            this.e = e;
        }

        public Node(Node next){
            this(next,null);
        }

        public Node(E e){
            this(null,e);
        }

        public Node(){
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    public LinkedListQueueByCQ(){
        size = 0;
        head = new Node();
        tail = new Node();
    }

    private int size;
    private Node head;
    private Node tail;

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if (null == tail){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }

        Node cur = head;
        head = cur.next;
        cur.next = null;
        if (head == null){
            tail = head;
        }
        size--;
        return cur.e;
    }//出队列

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }//队列头元素

    @Override
    public String toString(){
        Node cur = head;
        StringBuilder str = new StringBuilder();
        str.append(String.format("queue size=%d",size));
        str.append("Front[");
        while (cur!= null){
            str.append(cur.toString());
            if (cur.next!=null){
                str.append(",");
            }
            cur = cur.next;
        }
        str.append("]tail");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
