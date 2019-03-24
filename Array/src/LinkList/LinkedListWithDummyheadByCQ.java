package LinkList;

/**
 * Created by Administrator on 2019/2/15.
 */
public class LinkedListWithDummyheadByCQ<E> {
    private class Node<E>{
        private Node next;
        private E e;

        public Node(Node next,E e){
            this.e = e;
            this.next=next;
        }

        public Node(E e){
            this(null,e);
        }

        public Node(Node next){
            this(next,null);
        }

        public Node(){
            this(null,null);
        }

        public E getObject(){
            return e;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListWithDummyheadByCQ(){
        size = 0;
        dummyHead = new Node(null,null);
    }


    //链表任意位置插入元素
    public void add(int index,E e){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Index is not legal");
        }
        Node prve = dummyHead;
        for (int i=0;i<index;i++){
            prve = prve.next;
        }
//       prve.next = new Node(prve.next,e);
        Node newNode = new Node(prve.next,e);
        prve.next = newNode;
        size++;
    }

    //获取链表的大小
    public int getSize(){
        return size;
    }

    //链表尾增加元素
    public void addLast(E e){
        add(size,e);
    }

    //链表头增加元素
    public void addFirst(E e){
        add(0,e);
    }

    //查找指定位置的元素
    public E get(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Index is not legal");
        }
        Node prve =dummyHead;
        for (int i=0;i<index;i++){
            prve = prve.next;
        }
        return (E) prve.e;
    }

    //返回头结点
    public Node<E> getFirstNode(){
        Node r = dummyHead.next;
        if (r == null){
            throw new IllegalArgumentException("头结点不存在");
        }
        return r;
    }

    //获取头结点元素
    public E getFirst(){
        return get(0);
    }

    //获取尾节点元素
    public E getLast(){
        return get(size-1);
    }

    //删除指定位置的元素并返回该元素的值
    public E remove(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Index is not legal");
        }
        Node del = dummyHead;
        for (int i=0;i<index;i++){
            del = del.next;
        }
        Node re = del.next;
        del.next = del.next.next;
        re.next = null;
        size--;
        return (E)re.e;
    }

    //删除头元素
    public E removeFirst(){
        return remove(0);
    }

    //删除尾元素
    public E removeLast(){
        return remove(size-1);
    }

    //修改指定未知的元素
    public void set(int index,E e){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Index is not legal");
        }
        Node prve = dummyHead;
        for (int i=0;i<index;i++){
            prve = prve.next;
        }
        prve.e = e;
    }

    //修改头元素
    public void setHead(E e){
        set(0,e);
    }

    //修改尾元素
    public void setTail(E e){
        set(size-1,e);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("LinkedList size:%d",size));
        str.append("head:");
        Node prve = dummyHead.next;
        for (int i =0 ;i<size;i++){
            str.append(prve.e);
            prve = prve.next;
            if (i != size -1){
                str.append("->");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListWithDummyheadByCQ<Integer> linkList = new LinkedListWithDummyheadByCQ<Integer>();

        for (int i=0;i<5;i++){
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.add(2,666);
        System.out.println(linkList);

        linkList.add(4,888);
        System.out.println(linkList);

        linkList.remove(2);
        System.out.println(linkList);

        linkList.removeFirst();
        System.out.println(linkList);

        linkList.removeLast();
        System.out.println(linkList);
    }
}
