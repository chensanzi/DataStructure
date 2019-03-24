package UnionFind;

/**
 * Created by Administrator on 2019/3/8.
 */
public class UnionFind2CyCQ implements UF{

    private int[] parent;

    public UnionFind2CyCQ(int size){
        parent = new int[size];

        for (int i=0;i<size;i++){
            parent[i] = i;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    public int find(int p){
        if (p<0||p>=parent.length){
            throw new IllegalArgumentException("Index is out bound");
        }

        while (p != parent[p]){
            p = parent[p];
        }

        return p;
    }

    @Override
    public boolean isConnected(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        return pRoot == qRoot;
    }

    @Override
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        parent[pRoot] = qRoot;
    }


}
