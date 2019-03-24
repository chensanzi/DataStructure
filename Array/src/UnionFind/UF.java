package UnionFind;

/**
 * Created by Administrator on 2019/2/28.
 */
public interface UF {

    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
