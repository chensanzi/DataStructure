package Stack;

import Array.ArrayByCQ;

import java.util.*;

/**
 * Created by Administrator on 2019/2/15.
 */
public class ArrayStackByCQ<E> implements Stack<E>{

    private ArrayByCQ<E> stack;
    public ArrayStackByCQ(){
        stack = new ArrayByCQ<E>();
    }

    @Override
    public int getSize(){
        return stack.getSize();
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public void push(E e){
        stack.addLast(e);
    }

    @Override
    public E pop(){
        return stack.removeLast();
    }

    @Override
    public E peek(){
        return stack.getLast();
    }

    public E get(int index){
        return stack.get(index);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Stack:[");
        for (int i=0;i<getSize();i++){
            str.append(get(i).toString());
            if (i != getSize()-1){
                str.append(",");
            }
        }
        str.append("]top");
        return str.toString();
    }
}
