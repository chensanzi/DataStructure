package Set;

import LinkList.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/16.
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<E>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e){
        return list.contains(e);
    }

    @Override
    public void add(E e){
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e){
//        list.removeElement(e);
    }

    public static void main(String[] args) {
//        System.out.println("Pride and Prejudice");
//
//        LinkedListSet<String> words1 = new LinkedListSet<String>();
////        FileOperation.readFile("pride-and-prejudice.txt",words1);
//        System.out.println("Total words:"+words1.size());
//
//        BSTSet<String> set1 = new BSTSet(){};
//        for (String word:words1){
//            set1.add(word);
//        }
//        System.out.println("Total different words:"+set1.getSize());

    }
}
