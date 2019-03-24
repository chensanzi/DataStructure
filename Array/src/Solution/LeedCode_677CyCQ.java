package Solution;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/3/2.
 */
public class LeedCode_677CyCQ {
    private class Node{
        private int value;
        private TreeMap<Character,Node> next;

        public Node(){
            next = new TreeMap<Character,Node>();
        }
    }

    private Node root;

    public LeedCode_677CyCQ(){
        root = new Node();
    }

    public void insert(String word,int value){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(word.charAt(i))==null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = value;
    }

    public int sum(String prefix){
        Node cur = root;
        for (int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }


    private int sum(Node node){
        if (node.next == null){
            return node.value;
        }

        int res = node.value;

        for (char c:node.next.keySet()){
            res += sum(node.next.get(c));
        }

        return res;
    }

    public static void main(String[] args) {
        LeedCode_677CyCQ leedCode677CyCQ = new LeedCode_677CyCQ();
        leedCode677CyCQ.insert("apple",3);
        System.out.println(leedCode677CyCQ.sum("ap"));
        leedCode677CyCQ.insert("app",2);
        System.out.println(leedCode677CyCQ.sum("ap"));
    }
}
