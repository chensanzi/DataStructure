package UnionFind;

/**
 * Created by Administrator on 2019/3/8.
 */
public class UnionFind1CyCQ implements UF{
    private int[] data;

    public UnionFind1CyCQ(int size){
        data = new int[size];

        for (int i=0;i<size;i++){
            data[i] = i;
        }
    }

    @Override
    public int getSize(){
        return data.length;
    }

    private int findParent(int element){
        if (element<0||element>=data.length){
            throw new IllegalArgumentException("index is error");
        }

        return data[element];
    }

    /**
     * 判断 p q 是否连接
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p,int q){
        if (p<0||p>=data.length||q<0||q>=data.length){
            throw new IllegalArgumentException("index is error");
        }

        return findParent(p) == findParent(q);
    }

    @Override
    public void unionElements(int p,int q){
        if (p<0||p>=data.length||q<0||q>=data.length){
            throw new IllegalArgumentException("index is error");
        }

        if (isConnected(p,q)){
            return;
        }

        for (int i=0;i<data.length;i++){
            if (data[i]==p){
                data[i]=q;
            }
        }
    }
}
