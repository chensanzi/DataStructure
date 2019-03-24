package Stack;


import LinkList.LinkedListWithDummyheadByCQ;

/**
 * Created by Administrator on 2019/2/16.
 */
public class LinkedListStackByCQ<E> implements Stack<E> {
    private LinkedListWithDummyheadByCQ<E> linkedListStack;

    public LinkedListStackByCQ(){
        linkedListStack = new LinkedListWithDummyheadByCQ<E>();
    }

    @Override
    public int getSize(){
        return linkedListStack.getSize();
    }

    @Override
    public boolean isEmpty(){
        return linkedListStack.isEmpty();
    }

    @Override
    public void push(E e){
        linkedListStack.addFirst(e);
    }

    @Override
    public E pop(){
        return linkedListStack.removeFirst();
    }

    @Override
    public E peek(){
        return linkedListStack.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Stack top:[");
        str.append(linkedListStack);
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListStackByCQ<Integer> stack = new LinkedListStackByCQ<Integer>();

        for (int i = 0 ;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
