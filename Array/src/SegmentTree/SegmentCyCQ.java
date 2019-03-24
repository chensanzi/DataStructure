package SegmentTree;

/**
 * Created by Administrator on 2019/2/27.
 */
public class SegmentCyCQ<E>{
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentCyCQ(E[] arr,Merger merger){
        data = (E[])new Object[arr.length];
        tree = (E[])new Object[arr.length*4];

        this.merger = merger;
        for (int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        buildSegmentTree(0,0,data.length-1);
    }

    private void buildSegmentTree(int treeIndex,int l,int r){
       if (l==r){
           tree[treeIndex] = data[l];
           return;
       }
        int mid = l+(r-l)/2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        buildSegmentTree(leftChild,l,mid);
        buildSegmentTree(rightChild,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);
    }

    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }

    public E query(int queryL,int queryR){
        if (queryL<0||queryL>=tree.length||queryR<0||queryR>=tree.length||queryL>queryL){
            throw new IllegalArgumentException("Index is Illegal");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    //在以treeIndex为根节点的[1,r]的范围内寻找边界为[queryL,queryR]的结果集，
    // 需注意的是其中l,r费别表示treeIndex节点所承载线段树的范围
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
      if (queryL==l&&queryR==r){
          return tree[treeIndex];
      }

        int mid = l+(r-l)/2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if (queryL>mid){
            return query(rightChildIndex,mid+1,r,queryL,queryR);
        }else if (queryR<mid+1){
            return query(leftChildIndex,l,mid,queryL,queryR);
        }

        E leftResult = query(leftChildIndex,l,mid,queryL,mid);
        E rightResult = query(rightChildIndex,mid+1,r,mid+1,queryR);

        return merger.merge(leftResult,rightResult);
    }

    //更改date上index位置的元素为e，更改线段树
    public void set(E e,int index){
        if (index>data.length -1||index<0){
            throw new IllegalArgumentException("index is Illegal");
        }

        data[index] = e;
        //更改线段树的值
        set(0,0,data.length-1,index,e);
    }

    //更新data[index]的值为e后更新线段树tree。
    // 需注意的是其中l,r费别表示treeIndex节点所承载线段树的范围，当l=r时，该线段树已经到达叶子节点，
    // 而该叶子节点承载的就是data中索引为index的元素，更新该数据后将其父亲节点的值也进行更新即可。
    private void set(int treeIndex,int l,int r,int index ,E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l+(r-l)/2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if (index<mid+1){
            set(leftChildIndex,l,mid,index,e);
        }else {
            set(rightChildIndex,mid+1,r,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i=0;i<tree.length;i++){
            str.append(tree[i]);
            if (i!=tree.length-1){
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }
}
