import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
            if(set.size()<i+1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i<len; i++){
            nums[i] = s.nextInt();
        }

        System.out.println(containsDuplicate(nums));
    }
}
