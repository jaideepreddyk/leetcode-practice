import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

    public static int removeDuplicates (int[] arr){
        int placepointer = 0;

        // edge case
        if(arr.length == 1) return 1;
        
        for(int i=1; i<arr.length; i++){
            if (arr[placepointer]!=arr[i]){
                placepointer += 1; // increment pointer
                // swap only if i is ahead of placepointer and not if they are in the same position
                if(i>placepointer){
                    int temp = arr[i];
                    arr[i] = arr[placepointer];
                    arr[placepointer] = temp;
                }
            }
        }

        return placepointer + 1;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int arr_size = s.nextInt();
        int[] arr = new int[arr_size];
        for(int i = 0; i<arr_size; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
