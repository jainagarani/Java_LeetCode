package algorithms.search;

import java.util.Scanner;

public class UnSortedSmallerTarget {
    public static void main(String[] args) {
        int[] arr = {1,5, 7, 3, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a target");
        String numberStr = scanner.nextLine();
        int target =Integer.parseInt(numberStr);
        int result = Integer.MIN_VALUE;


        for(int i =0 ; i <arr.length; i++){
           if( arr[i]  < target && arr[i] > result){
               result = arr[i];
           }
        }

        System.out.println("Smaller than target is "+result);


    }
}
