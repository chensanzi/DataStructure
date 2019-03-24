package UnionFind;

import java.util.Random;

/**
 * Created by Administrator on 2019/2/28.
 */
public class Main {
    private static double testUF(UF uf,int m){

        long startTime = System.nanoTime();
        int size = uf.getSize();
        Random random = new Random();

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long ensTime = System.nanoTime();
        return (ensTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m =10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1:"+testUF(uf1,m)+"s");
//        UnionFind1CyCQ unionFind1CyCQ = new UnionFind1CyCQ(size);
//        System.out.println("unionFind1CyCQ:"+testUF(unionFind1CyCQ,m)+"s");

//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2:"+testUF(uf2,m)+"s");
//        UnionFind2CyCQ unionFind2CyCQ = new UnionFind2CyCQ(size);
//        System.out.println("UnionFind2CyCQ:"+testUF(unionFind2CyCQ,m)+"s");
//
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3:"+testUF(uf3,m)+"s");
        UnionFind3CyCQ unionFind3CyCQ = new UnionFind3CyCQ(size);
        System.out.println("unionFind3CyCQ:"+testUF(unionFind3CyCQ,m)+"s");


        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4:"+testUF(uf4,m)+"s");
        UnionFind4CyCQ unionFind4CyCQ = new UnionFind4CyCQ(size);
        System.out.println("unionFind4CyCQ:"+testUF(unionFind4CyCQ,m)+"s");
//
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5:"+testUF(uf5,m)+"s");
        UnionFind5CyCQ unionFind5CyCQ = new UnionFind5CyCQ(size);
        System.out.println("unionFind5CyCQ:"+testUF(unionFind5CyCQ,m)+"s");
//
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6:"+testUF(uf6,m)+"s");
        UnionFind6CyCQ unionFind6CyCQ = new UnionFind6CyCQ(size);
        System.out.println("unionFind6CyCQ:"+testUF(unionFind6CyCQ,m)+"s");


    }
}
