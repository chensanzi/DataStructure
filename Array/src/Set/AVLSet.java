package Set;

/**
 * Created by Administrator on 2019/3/2.
 */
public class AVLSet<E extends Comparable<E>> implements Set<E>{

    private AVLTree<E,Object> avl;

    public  AVLSet(){
        avl = new AVLTree<E, Object>();
    }

    @Override
    public int getSize(){
        return avl.getSize();
    }

    @Override
    public boolean isEmpty(){
        return avl.isEmpty();
    }

    @Override
    public void add(E e){
        avl.add(e,null);
    }

    @Override
    public boolean contains(E e){
        return avl.contains(e);
    }

    @Override
    public void remove(E e){
        avl.remove(e);
    }
}