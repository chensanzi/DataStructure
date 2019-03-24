package LinkList;

/**
 * Created by Administrator on 2019/1/30.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<Integer>();

        for (int i=0;i<5;i++){
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.add(2,666);
        System.out.println(linkList);

        linkList.remove(2);
        System.out.println(linkList);

        linkList.removeFirst();
        System.out.println(linkList);

        linkList.removeLast();
        System.out.println(linkList);
    }

}
