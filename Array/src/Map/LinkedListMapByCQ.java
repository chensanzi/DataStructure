package Map;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/21.
 */
public class LinkedListMapByCQ<K,V> implements Map<K,V>{

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key,V value){
            this(key,value,null);
        }

        public Node(){
        }

        @Override
        public String toString(){
            return key.toString()+":"+value.toString();
        }
    }

    private Node dummyNode;
    private int size;

    public LinkedListMapByCQ(){
        dummyNode = new Node();
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    //获取键为key的node节点
    public Node getNode(K key){
        if (isEmpty()){
            return null;
        }

        Node prve = dummyNode;

        while(prve.next != null && !prve.next.key.equals(key)){
            prve = prve.next;
        }

        if (prve.next == null){
            //链表中没有该元素
            return null;
        }else{
            //prve.next 为键为key的node
           return prve.next;
        }
    }

    @Override
    public boolean contains(K key){
        Node node = getNode(key);

        return node == null?false:true;
    }

    @Override
    public void add(K key,V newValue){
        Node prve = dummyNode;

        while(prve.next != null && !prve.next.key.equals(key)){
                prve = prve.next;
        }

        if (prve.next == null){
            //链表中没有该元素，则在链表尾端挂上该元素
            Node newNode = new Node(key,newValue);
            prve.next = newNode;
            size++;
            return;
        }else{
            //该链表中已存在key，则将对应的value改成newValue
            prve.next.value = newValue;
        }
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key,V NewValue){
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException("map dones't have this key");
        }

        node.value = NewValue;
    }

    @Override
    public V remove(K key){
//        Node node = getNode(key);
//        if (node == null){
//            throw new IllegalArgumentException("map dones't have this key");
//        }
//
        Node prve = dummyNode;
        Node delnode;
        while (prve.next!=null && !prve.next.key.equals(key)){
            prve = prve.next;
        }

        if (prve.next == null){
//            throw new IllegalArgumentException("map dones't have this key");
            return null;
        }else{
            delnode = prve.next;
            prve.next = prve.next.next;
            size--;
        }

        if (delnode == null){
//            throw new IllegalArgumentException("map dones't have this key");
            return null;
        }
        return delnode.value;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("Map size=%d\n",size));

        Node prve = dummyNode;

        while (prve.next!=null){
            str.append(prve.next.toString()+"\n");
            prve = prve.next;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)){
            System.out.println("Total words:"+words.size());

            LinkedListMapByCQ<String,Integer>map = new LinkedListMapByCQ<String, Integer>();
            for (String word:words){
                if (map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            }

            System.out.println("Total different words:"+map.getSize());
            System.out.println("Frequency of RRIDE:"+map.get("pride"));
            System.out.println("Frequency of PRIEJUDICE:"+map.get("prejudice"));
            map.remove("prejudice");
            System.out.println("Frequency of PRIEJUDICE:"+map.get("prejudice"));
            System.out.println("Total different words:"+map.getSize());
        }


//            ArrayList<String> words = new ArrayList<String>();
//            words.add("A");
//            words.add("C");
//            words.add("G");
//            words.add("A");
//            words.add("A");
//            words.add("B");
//            words.add("A");
//            words.add("F");
//            words.add("C");
//            System.out.println("Total words:"+words.size());
//
//            LinkedListMapByCQ<String,Integer>map = new LinkedListMapByCQ<String, Integer>();
//            for (String word:words){
//                if (map.contains(word)){
//                    map.set(word,map.get(word)+1);
//                }else {
//                    map.add(word,1);
//                }
//            }
//
//            System.out.println("Total different words:"+map.getSize());
//            System.out.println("Frequency of C:"+map.get("C"));
//            System.out.println("Frequency of F:"+map.get("F"));
//            System.out.println("Frequency of A:"+map.get("A"));


//        LinkedListMapByCQ<String,Integer> map = new LinkedListMapByCQ<String, Integer>();
//        map.add("A",1);
//        map.add("D",34);
//        map.add("F",56);
//        map.add("B",2);
//        map.add("C",2);
//        System.out.println(map.toString());
//
//        System.out.println(map.contains("D"));
//        System.out.println(map.contains("G"));
//
//        System.out.println(map.toString());
//        map.set("A",3333);
//        System.out.println(map.toString());
    }
}
