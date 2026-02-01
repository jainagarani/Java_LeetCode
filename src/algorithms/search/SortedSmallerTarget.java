package algorithms.search;

import java.util.Scanner;

public class SortedSmallerTarget {

    public int closestSmaller(int[] arr, int target){
        int result = Integer.MIN_VALUE;
        int min =0;
        int max = arr.length-1;
        while(min <= max){
            int mid = min + (max-min)/2;

            if(arr[mid] < target){
                result = arr[mid];
                min = mid+1;
            }
            else{
                max = mid-1;
            }

        }
        return result;

    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        SortedSmallerTarget sortedSmallerTarget = new SortedSmallerTarget();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a target");
        int target = Integer.parseInt(scanner.nextLine());
        System.out.println(sortedSmallerTarget.closestSmaller(arr, target));


    }
}
