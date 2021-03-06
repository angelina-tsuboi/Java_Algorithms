import java.util.Arrays;

public class IntersectionTwoSets{
    private int[] array1;
    private int[] array2;

    public IntersectionTwoSets(int[] a, int[] a2){
        this.array1 = a;
        this.array2 = a2;
        Arrays.sort(array2);
    }

    public int getMatchingAmount(){
        int total = 0;
        for(int i = 0; i < array1.length; i++){
            int element = array1[i];
            int result = binarySearch(array2, 0, array2.length - 1, element);
            if(result != -1){
                total++;
            }
        }

        return total;
    }

    static int binarySearch(int arr[], int low, int high, int key) 
    { 
        if (high < low) 
            return -1; 
  
        /* low + (high - low)/2; */
        int mid = (low + high) / 2; 
        if (key == arr[mid]) 
            return mid; 
        if (key > arr[mid]) 
            return binarySearch(arr, (mid + 1), high, key); 
        return binarySearch(arr, low, (mid - 1), key); 
    } 

     public static void main(String args[]){
        int[] array1 = {1,2,4, 6};
        int[] array2 = {1,2,3, 6};
        IntersectionTwoSets its = new IntersectionTwoSets(array1, array2);
        System.out.println(its.getMatchingAmount());
    }
}