import java.util.Arrays;
import java.util.Scanner;

public class ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums){
        int[] ans = new int[nums.length*2];
        for(int i=0; i<nums.length; i++){
            ans[i] = nums[i];
            ans[i+nums.length] = nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] nums = new int[size];
        for(int i=0; i<size; i++){
            nums[i] = s.nextInt();
        }
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
