package SegmentTree;

/**
 * Created by Administrator on 2019/2/23.
 */
public class Main {
//    public static void main(String[] args) {
//        Integer[] num = {-2,0,3,-5,2,-1};
//        SegmentTree<Integer>segTree = new SegmentTree<Integer>(num, new Merger<Integer>() {
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;//根据业务逻辑改变
//            }
//        });
////        SegmentTree<Integer> segTree = new SegmentTree<Integer>(num,(a,b)->a+b);
////        System.out.println(segTree);
//
//        System.out.println(segTree.query(0,2));
//        System.out.println(segTree.query(2,5));
//        System.out.println(segTree.query(0,5));
//    }
    public static void main(String[] args) {
        Integer[] num = {-2,0,3,-5,2,-1};
        SegmentCyCQ segmentCyCQ = new SegmentCyCQ(num, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });

        System.out.println(segmentCyCQ);
        System.out.println(segmentCyCQ.query(2,5));
        System.out.println(segmentCyCQ.query(1,2));
        System.out.println(segmentCyCQ.query(4,5));
    }
}
