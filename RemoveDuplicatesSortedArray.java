import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray{
    public static int removeDuplicates(int[] arr){
        if(arr.length<2) return arr.length;
        int flagger = 1;
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                arr[flagger] = arr[i+1];
                flagger++;
            }
        }
        return flagger;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
