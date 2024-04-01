import java.util.ArrayList;

public class KthLargest {

    public class MinHeap{
        int[] heap;
        int capacity = 0;
        int k;
        MinHeap(int k){
            this.k = k;
            this.heap = new int[k+1];
        }

        public int parent(int index){
            return (index/2);
        }

        public int leftChild(int index){
            return (2*index);
        }

        public int rightChild(int index){
            return (2*index) + 1;
        }

        public void insert(int num){
            if(this.capacity<k){
                this.capacity++;
                heap[capacity] = num;
                siftUp(capacity);
            }
            else if(this.heap[1]<num){
                getMin();
                insert(num);
            }
            return;
        }

        public void siftUp(int index){
            if(parent(index)<1) return;
            int parent_val = heap[parent(index)];
            int curr_val = heap[index];
            if(parent_val>curr_val){
                heap[index] = parent_val;
                heap[parent(index)] = curr_val;
                siftUp(parent(index));
            }
            return;
        }

        public void siftDown(int index){
            int minIndex = index;
            int leftIdx = leftChild(index);
            int rightIdx = rightChild(index);
            if(leftIdx<=this.capacity && heap[minIndex]>heap[leftIdx]){
                minIndex = leftIdx;
            }
            if(rightIdx<=this.capacity && heap[minIndex]>heap[rightIdx]){
                minIndex = rightIdx;
            }
            if(minIndex==index){
                return;
            }
            else{
                //swap elements
                int temp = heap[minIndex];
                heap[minIndex]= heap[index];
                heap[index] = temp;
                siftDown(minIndex);
            }
            return;
        }

        public int getMin(){
            int min = heap[1];
            heap[1] = heap[capacity];
            this.capacity--;
            siftDown(1);
            return min;
        }
    }

    KthLargest.MinHeap myheap;
    public KthLargest(int k, int[] nums) {
        this.myheap = new MinHeap(k);
        if(nums.length>0){
            for(int num : nums){
                this.myheap.insert(num);
            }
        }
    }
    
    public int add(int val) {
        this.myheap.insert(val);
        return this.myheap.heap[1];
    }
}