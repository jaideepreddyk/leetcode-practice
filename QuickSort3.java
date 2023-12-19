import java.util.Arrays;
import java.util.Scanner;

public class QuickSort3 {
    public static void quickSort3(int[] arr){
        partition(arr, 0, arr.length);
    }
    public static void partition(int[] arr, int lower_idx, int upper_idx){
        if(upper_idx - lower_idx>1){
            int mid_lower;
            int mid_upper;
            int pivot = lower_idx + (upper_idx - lower_idx)/2;
            mid_lower = mid_upper = pivot;
            // run through the array once and sort the pivot element
            for(int i=lower_idx; i<upper_idx; i++){
                // greater than pivot val but on the left
                if(arr[i]>arr[mid_lower] && i<mid_lower){
                    // just swap
                    int temp = arr[i];
                    arr[i] = arr[mid_lower];
                    arr[mid_lower] = temp;
                    // reset pivot
                    mid_lower = mid_upper = i;
                }
                // less than pivot but on the right
                else if(arr[i]<arr[mid_upper] && i>mid_upper){
                    int temp = arr[mid_upper+1];
                    arr[mid_upper+1] = arr[i];
                    arr[i] = temp;
                    // swap mid_left with mid_right+1;
                    temp = arr[mid_upper + 1];
                    arr[mid_upper +1] = arr[mid_lower];
                    arr[mid_lower] = temp;
                    mid_lower += 1;
                    mid_upper += 1;
                }
                // equal to pivot
                else if(arr[i] == arr[mid_lower]){
                    if(i<mid_lower){
                        mid_lower = mid_upper = i;
                    }
                    else if(i>mid_upper){
                        int temp = arr[mid_upper+1]; 
                        arr[mid_upper+1] = arr[i];
                        arr[i] = temp;
                        mid_upper += 1;
                    }
                }
            }
            partition(arr, lower_idx, mid_lower);
            partition(arr, mid_upper+1, upper_idx);
        }
    }


    public static void main(String[] args){
        // Scanner s = new Scanner(System.in);
        // int size = s.nextInt();
        // int[] arr = new int[size];
        // for(int i=0; i<size; i++){
        //     arr[i] = s.nextInt();
        // }
        int[] complexAssArray = {2, 10, 7, 7, 3, 7, 2, 1, 10, 4, 5, 4, 9, 1, 5, 3, 2, 5, 6, 1, 8, 6, 1, 7, 8, 4, 6, 10, 3, 4, 2, 8, 8, 2, 10, 5, 2, 3, 1, 4, 3, 8, 3, 8, 7, 4, 2, 7, 5, 1};

        quickSort3(complexAssArray);
        System.out.println(Arrays.toString(complexAssArray));
    }
}
