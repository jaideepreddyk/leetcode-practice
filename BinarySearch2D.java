import java.util.Scanner;

public class BinarySearch2D {
    public static int binarySearchRow(int[][] nums, int target, int m){
        // return index of the row to binary search on
        int left = 0;
        int right = m - 1;// m here is the rows
        int n = nums[0].length;
        int middle = 0;
        while (left<=right) {
            middle = (left+right)/2;
            if(target<nums[middle][0]){
                right = middle-1;
            }
            else if(nums[middle][n-1]<target){
                left = middle+1;
            }
            else return middle;
        }
        // you can return either right or left because the while exits when they are equal
        return middle;
    }

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
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int row = binarySearchRow(matrix, target, m);
        int index = binarySearch(matrix[row], target);
        if(index==-1) return false;
        else return true;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int target  = s.nextInt();
        int[][] nums =  new int[m][n]; 
    }
}
