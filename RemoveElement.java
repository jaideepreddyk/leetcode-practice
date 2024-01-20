import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement{
    public static int removeElement(int[] nums, int val){
        if(nums.length==0) return 0;
        int last = nums.length-1;
        int k=0;
        for(int i=0; i<=last; i++){
            if(nums[i]==val){
                k++;
                while(nums[i]==val && last>i){
                    if(nums[last]!=val){
                        //swap
                        int temp = nums[i];
                        nums[i] = nums[last];
                        nums[last] = temp;
                    }
                    else k++;
                    last--;
                }
            }
        }
        return nums.length-k;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int val = s.nextInt();
        int size = s.nextInt();
        int[] nums = new int[size];
        for(int i=0; i<size; i++){
            nums[i] = s.nextInt();
        }
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
