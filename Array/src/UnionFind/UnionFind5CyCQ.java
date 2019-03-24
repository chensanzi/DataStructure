package UnionFind;

/**
 * Created by Administrator on 2019/3/8.
 */
public class UnionFind5CyCQ implements UF{

    private int[] parent;
    private int[] rank;//表示以i为根节点的树的高度

    public UnionFind5CyCQ(int size){
        parent = new int[size];
        this.rank = new int[size];

        for (int i=0;i<size;i++){
            parent[i] = i;
            this.rank[i] = 1;
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
            parent[p] = parent[parent[p]];
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

        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot]<rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot] ++;
        }
    }
}
