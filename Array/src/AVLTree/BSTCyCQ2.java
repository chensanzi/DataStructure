package AVLTree;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/3/9.
 */
public class BSTCyCQ2<K extends Comparable<K>, V> {
    private class Node{
        private K key;
        private V val;
        private Node left;
        private Node right;

        public Node(K key,V val){
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTCyCQ2(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(K key,V val){
        if (root == null){
            root = new Node(key,val);
            size ++;
            return;
        }

        root = add(root,key,val);
    }

    private Node add(Node node,K key,V val){
        if (node == null){
            size++;
            return new Node(key,val);
        }

        if (key.compareTo(node.key) <0){
           node.left = add(node.left,key,val);
        }else if (key.compareTo(node.key)>0){
            node.right = add(node.right,key,val);
        }
        return node;
    }

    public V get(K key){
        Node node = getNode(key);
        return node == null? null:node.val;
    }

    public void set(K key,V val){
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException("dont have");
        }
        node.val = val;
    }

    public Node getNode(K key){
        Node node = getNode(root,key);
//        if (node == null){
//            throw new IllegalArgumentException("dont have");
//        }
//        return node;
        return node;
    }

    public Node getNode(Node node,K key){

        if (node == null){
            return null;
        }

        if (key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else if (key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }else{
            return node;
        }
    }

    public boolean contains(K key){
        return getNode(key)!=null;
    }

    public Node findMinNode(){
        return findMinNode(root);
    }

    public Node findMinNode(Node node){
        if (node.left == null){
            return node;
        }

        return findMinNode(node.left);
    }

    public Node removeMin(){
        Node node = findMinNode();
        if (node == null){
            throw new IllegalArgumentException("BST is empty");
        }else{
            removeMin(root);
            return node;
        }
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key){
        Node node = getNode(key);
        if (null == node){
//            throw new IllegalArgumentException("do not have this key");
            return null;
        }
        root = remove(root,key);
        return node.val;
    }

    public Node remove(Node node,K key){

        if (node == null){
            return null;
        }



        if (key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }else{
            //node 为待删除节点
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }else if (node.right ==null){
                Node leftNode =node.left;
                size --;
                node.left = null;
                return leftNode;
            }

            //左右节点都存在
            Node rightMin = findMinNode(node.right);
            removeMin(node.right);
            rightMin.left = node.left;
            rightMin.right = node.right;
            node.right = node.left = null;
            return rightMin;
        }
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTCyCQ2<String, Integer> map = new BSTCyCQ2<String, Integer>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("1Total different words: " + map.getSize());
            System.out.println("1Frequency of PRIDE: " + map.get("pride"));
            System.out.println("1Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println();
            map.remove("pride");
//            map.remove("prejudice");
            System.out.println("1Total different words: " + map.getSize());
            System.out.println("1Frequency of PRIDE: " + map.get("pride"));
            System.out.println("1Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
