package algorithms.search;

public class BinarySearch {

    public int search(int[] arr, int target){
        int min =0;
        int max = arr.length-1;

        while(min <= max){
            int mid = min + (max -min)/2;
            if(arr[mid] == target)
                return mid;
          else if(arr[mid] < target){
              min = mid+1;
            }
          else if(arr[mid] > target){
              max = mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arr, 10));


    }
}
