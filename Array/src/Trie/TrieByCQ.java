package Trie;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/2/28.
 */
public class TrieByCQ<E> {
    private class Node{
        public boolean isWord;
        public  TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<Character,Node>();
        }

        public Node(){
            isWord = false;
            next =  new TreeMap<Character,Node>();
        }
    }

    private Node root;
    private int size;

    public TrieByCQ(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(String words){
        Node cur = root;
        for (int i=0;i<words.length();i++){
            char c = words.charAt(i);
            if (cur.next.get(c)==null){
                cur.next.put(c,new Node(false));
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            size++;
            cur.isWord = true;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     *
     * ["Trie","insert","search","search","startsWith","insert","search"]
     [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
     输出
     [null,null,true,false,false,null,true]
     预期结果
     [null,null,true,false,true,null,true]
     * @param args
     */
    public static void main(String[] args) {
        TrieByCQ trie = new TrieByCQ();
        trie.add("apple");
        System.out.println(trie.contains("apple"));
        System.out.println(trie.contains("app"));
        System.out.println(trie.isPrefix("app"));
        trie.add("app");
        System.out.println(trie.contains("app"));
    }
}
