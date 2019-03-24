package Stack;

/**
 * Created by Administrator on 2019/1/30.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
