package Trie;

import BST.BST;

/**
 * Created by Administrator on 2019/2/20.
 */
public class BSTSetByCQ<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst = new BST<E>();

    public BSTSetByCQ(){
        bst = null;
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    @Override
    public String toString(){
        return bst.toString();
    }
}
