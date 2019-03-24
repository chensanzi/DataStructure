package AVLTree;
import java.util.ArrayList;

public class AVLTreeByCQ<K extends Comparable<K>, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height=1;
        }
    }

    private Node root;
    private int size;

    public AVLTreeByCQ(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getHeight(Node node){

        if (node == null){
            return 0;
        }

        return node.height;
    }

    //判断是否是平衡二叉树
    public boolean isBST(){
        ArrayList<K> arrayList = new ArrayList<K>();
        inorder(root,arrayList);
        for (int i=1;i<arrayList.size();i++){
            if (arrayList.get(i-1).compareTo(arrayList.get(i))>0){
                return false;
            }
        }
        return true;
    }

    private void inorder(Node node,ArrayList<K> arrayList){
        if (node == null){
            return;
        }

        inorder(node.left,arrayList);
        arrayList.add(node.key);
        inorder(node.right,arrayList);
    }

    public boolean isBalance(){
        return isBalance(root);
    }

    public boolean isBalance(Node node){
        if (node == null){
            return true;
        }

        int balanceFactor = getBalanceFactor(node);

        if (Math.abs(balanceFactor)>1){
            return false;
        }

        return isBalance(node.left)&&isBalance(node.right);
    }

    //计算balance值
    public int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    public Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;
        y.left = T3;
        x.right = y;

        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        y.right = T2;
        x.left = y;
//
//        y.height = Math.max(y.left.height,y.right.height)+1;
//        x.height = Math.max(x.left.height,x.right.height)+1;

        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        //维护height
//        node.height = Math.max(node.left.height,node.right.height)+1;
        node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;


        //维护平衡
        int balanceFactor = getBalanceFactor(node);
        //LL
        if (balanceFactor>1 && getBalanceFactor(node.left)>=0){
            return rightRotate(node);
        }

        if(balanceFactor<-1 && getBalanceFactor(node.right)<=0){
            //RR
            return leftRotate(node);
        }

        if(balanceFactor>1 && getBalanceFactor(node.left)<0){
            //LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(balanceFactor<-1 && getBalanceFactor(node.right)>0){
            //RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
//    private Node removeMin(Node node){
//
//        if(node.left == null){
//            Node rightNode = node.right;
//            node.right = null;
//            size --;
//            return rightNode;
//        }
//
//        node.left = removeMin(node.left);
//        node.height = Math.max(getHeight(node.left),getHeight(node.right));
//        return node;
//    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        Node rote;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            rote = node;
        } else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            rote = node;
        } else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                rote = rightNode;
            }

            // 待删除节点右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                rote = leftNode;
            }else{
                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                rote = successor;
            }
        }

        if (rote == null){
            return null;
        }

        //维护height
        rote.height = 1 + Math.max(getHeight(rote.left),getHeight(rote.right));

        //维护平衡
        int balanceFactor = getBalanceFactor(rote);
        //LL
        if (balanceFactor>1 && getBalanceFactor(rote.left)>=0){
            rote = rightRotate(rote);
        }else if(balanceFactor<-1 && getBalanceFactor(rote.right)<=0){
            //RR
            rote = leftRotate(rote);
        }else if(balanceFactor>1 && getBalanceFactor(rote.left)<0){
            //LR
            node.left = leftRotate(rote.left);
            rote = rightRotate(rote);
        }else if(balanceFactor<-1 && getBalanceFactor(rote.right)>0){
            //RL
            node.right = rightRotate(rote.right);
            rote = leftRotate(rote);
        }

        return rote;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTreeByCQ<String, Integer> map = new AVLTreeByCQ<String, Integer>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST:"+map.isBST());
            System.out.println("is Balanced:"+map.isBalance());
            for (String word:words){
                map.remove(word);
                if (!map.isBST() || !map.isBalance()){
                    throw new RuntimeException("Error");
                }
            }
        }

        System.out.println();
    }
}