package Set;


import Solution.LinkedListSolutionByCQ;

/**
 * Created by Administrator on 2019/2/20.
 */
public class LinkedListSetByCQ<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSetByCQ(){
        this.list = new LinkedList();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public void add(E e){
        if (list.contains(e)){
            return;
        }
        list.addLast(e);
    }

    @Override
    public boolean contains(E e){
        return list.contains(e);
    }

    @Override
    public void remove(E e){
        if (!list.contains(e)){
            return;
        }
        list.removeElement(e);
    }
}
