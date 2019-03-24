package Solution;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/2/28.
 */
class WordDictionary {
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



    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    /** Adds a word into the data structure. */
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
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
                if ( match(cur.next.get(word.charAt(c)),index+1,word)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary leetCode211 = new WordDictionary();
//        leetCode211.addWord("apple");
        leetCode211.addWord("bad");
        leetCode211.addWord("dad");
        leetCode211.addWord("mad");
        System.out.println(leetCode211.search("pad"));
        System.out.println(leetCode211.search("bad"));
        System.out.println(leetCode211.search(".ad"));
        System.out.println(leetCode211.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
