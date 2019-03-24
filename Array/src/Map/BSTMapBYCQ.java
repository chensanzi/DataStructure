package Map;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/21.
 */
public class BSTMapBYCQ<K extends Comparable<K>,V> implements Map<K,V>{

    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key,V value){
            this.key = key;
            this.value=value;
            left = null;
            right = null;
        }

//        public Node(){
//            this.key = null;
//            this.value=null;
//            left = null;
//            right = null;
//        }
    }

    private Node root;
    private int size;

    public BSTMapBYCQ(){
        root = null;
        size = 0;
    }

    //获得树的规模
    @Override
    public int getSize(){
        return size;
    }

    //判断map是否为空
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    //map中是否含有键key
    @Override
    public boolean contains(K key){
        if (isEmpty()){
            return false;
        }

        return contains(root,key);
    }

    private boolean contains(Node node,K key){
//        if (node == null){
//            return false;
//        }
//
//        if (key.compareTo(node.key)<0){
//            return contains(node.left,key);
//        }else if(key.compareTo(node.key)>0){
//            return contains(node.right,key);
//        }else {
//            //key在树中存在，则返回true；
//            return true;
//        }
        return getNode(node,key) == null?false:true;
    }

    //添加元素，其中键为key，值为value
    @Override
    public void add(K key,V value){
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if (node == null){
            node = new Node(key,value);
            size++;
            return node;
        }

        if (key.compareTo(node.key)<0){
            node.left = add(node.left,key,value);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
            return node;
        }else{
            // key 存在则将原有key对应的值改成value
            node.value = value;
            return node;
        }
    }
    //返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    //获得key键对应的值value
    @Override
    public V get(K key){
//        if (!contains(key)){
//            return null;
//        }
//        return get(root,key);
        Node node = getNode(root,key);
        return node==null?null:node.value;
    }

//    private V get(Node node,K key){
//        if (node == null){
//            return null;
//        }
//
//        if (key.compareTo(node.key)<0){
//            return get(node.left,key);
//        }else if (key.compareTo(node.key)>0){
//            return get(node.right,key);
//        }else{
//           // 找到key对应的value
//            return node.value;
//        }
//    }

    //更改key对应的值
    @Override
    public void set(K key,V value){
        if (!contains(key)){
            throw new IllegalArgumentException("map doesn't hava key:"+key);
        }
        set(root,key,value);
    }

    private void set(Node node,K key,V newValue){
        if (node == null){
            return ;
        }

        if (key.compareTo(node.key)<0){
             set(node.left,key,newValue);
        }else if (key.compareTo(node.key)>0){
             set(node.right,key,newValue);
        }else{
            // 找到key对应的value
            node.value = newValue;
            return ;
        }
    }

    //找到map中最小的key对应的节点
    private Node findMinKey(){
        return findMinKey(root);
    }

    private Node findMinKey(Node node){
        if (node.left == null){
            return node;
        }

        return findMinKey(node.left);
    }


    //找到map中最da的key对应的节点
    private Node findMaxKey(){
        return findMaxKey(root);
    }

    private Node findMaxKey(Node node){
        if (node.right == null){
            return node;
        }

        return findMaxKey(node.right);
    }

    //删除二叉树中最小值
    private void removeMin(){
        removeMin(root);
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    //删除map中值，其中键为key
    @Override
    public V remove(K key){
        if (!contains(key)){
            throw new IllegalArgumentException("this key doesn't exist!");
        }
        V value = get(key);
        remove(root,key);
        return value;
    }

    private Node remove(Node node,K key){
        if (node == null){
            throw new IllegalArgumentException("this key doesn't exist!");
        }

        if (key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }else{
            //此时的node.key == key，node即为待删除节点

            if (node.right == null){
                //该节点仅可能存在左子树时：将左子树替换该节点
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else if (node.left == null){
                //该节点仅可能存在右子树时：将右子树替换该节点
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else{
              //该节点既存在左子树也存在右子树，此时找到右子树的key最小值对应的节点，并将该节点替换需删除的节点。
               Node successor = findMinKey(node.right);
                Node newRightNode = removeMin(node.right);
                Node newLeftNode = node.left;

                node.left = null;
                node.right = null;
                size--;

                successor.left = newLeftNode;
                successor.right = newRightNode;
                size++;
                return successor;
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("map:");
        String ret = generateDepthString(root,0,str).toString();
        return ret;
    }

    private StringBuilder generateDepthString(Node node,int depth,StringBuilder str){
        if (node == null){
            str.append(generateDepth(depth)+"null\n");
            return str;
        }
        str.append(generateDepth(depth)+"key:"+node.key+";value:"+node.value+"\n");
//        str.append(generateDepth(depth)+"key:"+node.key+"\n");
        generateDepthString(node.left,depth+1,str);
        generateDepthString(node.right,depth+1,str);
        return str;
    }

    private String generateDepth(int depth){
        String depthString="";
        for (int i =0;i<depth;i++){
            depthString = depthString+"--";
        }
        return depthString;
    }


    public static void main(String[] args) {
//        System.out.println("pride And prejudice");
//        ArrayList<String> words = new ArrayList<String>();
//
//        BSTMapBYCQ<String,Integer> map = new BSTMapBYCQ<String, Integer>();
//        String fileName = "pride-and-prejudice.txt";
//        if (FileOperation.readFile(fileName,words)){
//            for (String word:words){
//                if (map.contains(word)){
//                    map.set(word,map.get(word)+1);
//                }else {
//                    map.add(word,1);
//                }
//            }
//        }
//        System.out.println("Total words:"+words.size());
//        System.out.println("Total different words:"+map.getSize());
//        System.out.println("pride frequence is :"+map.get("pride"));
//        System.out.println("prejudice frequence is :"+map.get("prejudice"));

        BSTMapBYCQ<String,Integer> map = new BSTMapBYCQ<String, Integer>();
        map.add("A",1);
        map.add("H",22);
        map.add("L",12);
        map.add("D",12);
        map.add("E",33);
        map.add("F",11);
        map.add("Q",89);
        System.out.println(map.toString());

        map.remove("L");
        System.out.println(map.toString());

        map.set("D",1000);
        System.out.println(map.toString());
//        map.add("5",1);
//        map.add("3",22);
//        map.add("6",12);
//        map.add("8",12);
//        map.add("4",33);
//        map.add("2",11);
//        System.out.println(map.toString());

    }
}
