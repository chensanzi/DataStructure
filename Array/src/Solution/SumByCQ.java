package Solution;

/**
 * Created by Administrator on 2019/2/18.
 */
public class SumByCQ {
    public void sum(int[] arr){
        int s = sum(arr,0);
        System.out.println(s);
    }

    private int sum(int[]arr,int l){
        if (l == arr.length){
            return 0;
        }

        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        new SumByCQ().sum(arr);
//        [1,2,3,4,5,6,7,8,9];
    }
}
