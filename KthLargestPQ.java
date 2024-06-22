import java.util.PriorityQueue;
import java.util.Collections;

public class KthLargestPQ {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<nums.length; i++){
            maxHeap.add(nums[i]);
        }

        // extract kth largest element
        int kth_element = 0;
        for(int i =0; i<k; i++){
            kth_element = maxHeap.poll();
        }
        return kth_element;
    }
}
