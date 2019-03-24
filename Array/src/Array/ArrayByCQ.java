package Array;

/**
 * Created by Administrator on 2019/2/15.
 */
public class ArrayByCQ<E> {
    private E[] date;
    private int size;

    public ArrayByCQ(int capacity){
        date = (E[]) new Object[capacity];
        size = 0;
    }

    //默认的无参构造方法的数组容量为10
    public ArrayByCQ(){
        this(10);
    }

    //获取数组size
    public int getSize(){
        return size;
    }

    //获取数组的容积
    public int getCapacity(){
        return date.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取数组任意位置元素
    public E get(int index){
        if (index<0 || index >=size){
            throw new IllegalArgumentException("Index is not legal");
        }
        return date[index];
    }

    //获取数组头元素
    public E getFirst(){
        return get(0);
    }

    //获取数组尾部元素
    public E getLast(){
        return get(size-1);
    }

    //向数组index位置添加一个元素
    public void add(int index,E e){
        if (index<0 || index >size){
            throw new IllegalArgumentException("Index is not legal");
        }

        if (size == date.length){
//            throw new IllegalArgumentException("data is full");
            resize(date.length*2);
        }

        for (int i=size;i>index;i--){
            date[i] = date[i-1];
        }

        date[index] = e;
        size++;
    }

    //向数组元素头插入一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //向数组元素末尾插入一个元素
    public void addLast(E e){
        add(size,e);
    }

    //删除指定位置的元素,并返回删除的元素
    public E remove(int index){
        if (index<0 || index >=size){
            throw new IllegalArgumentException("Index is not legal");
        }

        E e = date[index];

        for (int i=index;i<size;i++){
            date[i] = date[i+1];
        }
        date[size -1] = null;
        size--;

        if (size<date.length/4 && date.length/2!=0){
            resize(date.length/2);
        }
        return e;
    }

    //删除数组头元素
    public E removeFirst(){
        return remove(0);
    }

    //删除数组元素末尾元素
    public E removeLast(){
        return remove(size-1);
    }

    //删除指定元素
    public void del(E e){
        int i = find(e);
        if (i != -1){
            remove(i);
        }
    }



    //查找指定元素，并返回索引。若没有则返回-1
    public int find(E e){
        for (int i = 0;i<size;i++){
            if (date[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    //更改某位置的元素
    public void set(int index,E e){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("index is not legal");
        }
        date[index] = e;
    }


    //扩容或缩容
    public void resize(int newCapacity){
        System.out.println("触发resize函数");
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = date[i];
        }
        date = newData;
    }

    @Override
    public String toString(){
//        StringBuilder str = new StringBuilder();
//        String str = "";
//        for (int i=0;i<size;i++){
//            str = str + date[i].toString();
//            if (i != size-1){
//                str = str +",";
//            }
//        }
//        return str;
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array size=%d,capacity=%d",size,date.length));
        str.append("[");
        for (int i=0;i<size;i++){
            str.append(date[i]);
            if (i<size-1){
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();

    }

    public static void main(String[] args) {
        ArrayByCQ<Integer> arrayByCQ = new ArrayByCQ<Integer>(1);
//        ArrayByCQ<Integer> arrayByCQ = new ArrayByCQ<Integer>(10);
        for (int i=0;i<8;i++){
            arrayByCQ.add(i,i);
        }
        System.out.println(arrayByCQ.toString());
        arrayByCQ.add(2,100);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.addFirst(33);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.addLast(44);
        System.out.println(arrayByCQ.toString());


        arrayByCQ.remove(2);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.removeFirst();
        System.out.println(arrayByCQ.toString());
        arrayByCQ.removeLast();
        System.out.println(arrayByCQ.toString());
        arrayByCQ.del(100);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
        arrayByCQ.remove(0);
        System.out.println(arrayByCQ.toString());
    }
}
