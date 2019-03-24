package Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int[] arr = new int[20];
//        for (int i =0;i<arr.length;i++){
//            arr[i] = i;
//        }
//
//        int[] scores = new int[]{100,98,90};
//        for (int score:scores){
//            System.out.println(score);
//        }
//
//        scores[1] = 99;
//        for (int score:scores){
//            System.out.println(score);
//        }

        Array<Integer> array = new Array();
        for (int i=0;i<10;i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);//// TODO: 2019/1/28
        System.out.println(array);
        
        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }
}
