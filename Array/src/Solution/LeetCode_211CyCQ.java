package Solution;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/2/28.
 */
public class LeetCode_211CyCQ {
    private class Node{
        private TreeMap<Character,Node> next;
        private boolean isWords;

        public Node(boolean isWords){
            this.isWords = isWords;
            next = new TreeMap<Character,Node>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public LeetCode_211CyCQ(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWords = true;
    }

    public boolean search(String word) {
        if (word.length()<=0){
            return false;
        }
        return match(root,0,word);
    }

    public boolean match(Node cur,int index,String word){
        if (index == word.length()){
            return cur.isWords;
        }

        if (word.charAt(index) != '.'){
            if (cur.next.get(word.charAt(index)) == null){
                return false;
            }else {
                return match(cur.next.get(word.charAt(index)),index+1,word);
            }
        }else{
            for (char c:cur.next.keySet()){
                if ( match(cur.next.get(c),index+1,word)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     *
     ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_211CyCQ leetCode211 = new LeetCode_211CyCQ();
//        leetCode211.addWord("apple");
        leetCode211.addWord("bad");
        leetCode211.addWord("dad");
        leetCode211.addWord("mad");
//        System.out.println(leetCode211.search("pad"));
//        System.out.println(leetCode211.search("bad"));
        System.out.println(leetCode211.search(".ad"));
        System.out.println(leetCode211.search("b.."));
    }
}
