import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left<=right) {
            int middle = (left+right)/2;
            if(nums[middle]>target){
                right = middle-1;
            }
            else if(nums[middle]<target){
                left = middle+1;
            }
            else return middle;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int target  = s.nextInt();
        int[] nums =  new int[size];
        for(int i=0; i<size; i++){
            nums[i] = s.nextInt();
        }
        System.out.println(binarySearch(nums, target));
    }
}
