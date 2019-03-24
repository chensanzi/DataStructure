package BST;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2019/2/19.
 */
public class BSTByCQ<E extends Comparable> {
    private class Node{
        private E e;
        private Node left;
        private Node right;

        private Node(){
            e = null;
            left = null;
            right = null;
        }

        private Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTByCQ(){
        root = null;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    //添加元素到二叉树
    public void add(E e){
        root = add(root,e);
    }

    public Node add(Node node,E e){
        if (node == null){
            node = new Node(e);
            size++;
            return node;
        }

        if (e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if (e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    //二叉树是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e)==0){
            return true;
        }else if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //二叉树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    //二叉树的前序遍历（非递归 用栈实现）
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        if (root!=null){
            stack.push(root);
        }

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }


    //二叉树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二叉树的后序遍历
    public void afterOrder(){
        afterOrder(root);
    }

    public void afterOrder(Node node){
        if (node == null){
            return;
        }

        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);
    }

    //二叉树层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList();
        if (root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //寻找二叉树中值最小的节点
    public E findMin(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return findMin(root);
    }

    public E findMin(Node node){
        if (node.left == null){
            return node.e;
        }

        E flag = findMin(node.left);
        return flag;
    }

    //寻找二叉树中值最大的节点
    public E findMax(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return findMax(root);
    }

    public E findMax(Node node){
        if (node.right == null){
            return node.e;
        }

        E flag = findMax(node.right);
        return flag;
    }

    //删除二叉树最小值
    public E removeMin(){
        E min = findMin();
        removeMin(root);
        return min;
    }

    public Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除二叉树的最大节点
    public E removeMax(){
        E max = findMax();
        removeMax(root);
        return max;
    }

    public Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.right = null;
            size -- ;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        return generateDepthString(root,str,0).toString();
//        return str.toString();
    }

    public StringBuilder generateDepthString(Node node,StringBuilder str,int depth){
        if (node == null){
            str.append(generateDepth(depth)+"null\n");
            return str;
        }
        str.append(generateDepth(depth)+node.e+"\n");
        generateDepthString(node.left,str,depth+1);
        generateDepthString(node.right,str,depth+1);
        return str;
    }

    public String generateDepth(int depth){
        StringBuilder str = new StringBuilder();
        for (int i=0;i<depth;i++){
            str.append("--");
        }
        return str.toString();
    }

    //删除二叉树值为e的节点
    public void removeElement(E e){
        if (!contains(e)){
            return ;
        }
        removeElement(root,e);
    }


    public Node removeElement(Node node,E e){
        if (node == null){
            return node;
        }

        if (e.compareTo(node.e)<0){
            node.left = removeElement(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right = removeElement(node.right,e);
            return node;
        }

        //当待删除节点只有左子树
        if (node.right == null){
            Node leftNode = node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        //当待删除节点只有右子树
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        //找到node右子树的最小值替换node
        E rightMin = findMin(node.right);
        removeMin(node.right);
        size--;

        node.e = rightMin;
        size++;
        return node;

        //待删除节点左右子树均不为空的情况
        //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
        //用这个节点顶替待删除节点的位置
//        Node successor = minimum(node.right);
//        successor.right = removeMin(node.right);
//        size++;
//
//        successor.left = node.left;
//
//        node.left = node.right = null;
//        size--;
//        return successor;
    }

    public static void main(String[] args) {
        BSTByCQ bst = new BSTByCQ();
        int[] arr ={5,3,6,8,4,2,1,7,9,10};
        for (int a:arr){
            bst.add(a);
        }

//        bst.preOrder();
//        System.out.println("---------------");
//        bst.inOrder();
//        System.out.println("---------------");
//        bst.afterOrder();
//        System.out.println("---------------");
//        Node min = bst.findMin();
//        System.out.println(bst.findMin());
//        System.out.println(bst.findMax());

//        bst.inOrder();
//        System.out.println("---------------");
//
////        System.out.println(bst.removeMin());
////        System.out.println("---------------");
////        bst.inOrder();
//
////        System.out.println("---------------");
//        System.out.println(bst.removeMax());
//        System.out.println("---------------");
//        bst.inOrder();

//        bst.preOrder();
//        System.out.println("-------------");
//        bst.preOrderNR();
//        System.out.println(bst.toString());

        System.out.println(bst);
        bst.removeElement(10);
        System.out.println("*******************************************************");
        System.out.println(bst);
    }
}
