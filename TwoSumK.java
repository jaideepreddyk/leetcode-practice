import java.util.Arrays;
import java.util.Scanner;

public class TwoSumK {

    public static int twoSumLessThanK(int[] nums, int k) {
        QuickSort3.quickSort3(nums);
        int start_idx = 0;
        int end_idx = nums.length - 1;
        int max_sum = -1;
        while(end_idx-start_idx>0){
            int i = nums[start_idx];
            int j = nums[end_idx];
            if(i+j < k){
                if(i+j>max_sum) max_sum = i+j;
                start_idx += 1;
            }
            else end_idx -= 1;
        }
        return max_sum;
    }

    public static void main(String[] args){
        // Scanner s = new Scanner(System.in);
        // int len = s.nextInt();
        // int k = s.nextInt();
        // int[] arr = new int[len];
        // for(int i=0; i<len; i++){
        //     arr[i] = s.nextInt();
        // }
        int[] arr = {358,898,450,732,672,672,256,542,320,573,423,543,591,280,399,923,920,254,135,952,115,536,143,896,411,722,815,635,353,486,127,146,974,495,229,21,733,918,314,670,671,537,533,716,140,599,758,777,185,549};
        System.out.println(twoSumLessThanK(arr, 1800));
    }
}
