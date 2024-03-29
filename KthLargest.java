import java.util.ArrayList;

public class KthLargest {

    public class MaxHeap{
        int[] heap;
        int capacity = 0;

        MaxHeap(){
            heap = new int[10000];
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
            this.capacity++;
            heap[capacity] = num;
            siftUp(capacity);
        }

        public void siftUp(int index){
            if(parent(index)<1) return;
            int parent_val = heap[parent(index)];
            int curr_val = heap[index];
            if(parent_val<curr_val){
                heap[index] = parent_val;
                heap[parent(index)] = curr_val;
                siftUp(parent(index));
            }
            return;
        }

        public void siftDown(int index){
            int maxIndex = index;
            int leftIdx = leftChild(index);
            int rightIdx = rightChild(index);
            if(leftIdx<=this.capacity && heap[maxIndex]<heap[leftIdx]){
                maxIndex = leftIdx;
            }
            if(rightIdx<=this.capacity && heap[maxIndex]<heap[rightIdx]){
                maxIndex = rightIdx;
            }
            if(maxIndex==index){
                return;
            }
            else{
                //swap elements
                int temp = heap[maxIndex];
                heap[maxIndex]= heap[index];
                heap[index] = temp;
                siftDown(maxIndex);
            }
            return;
        }

        public int getMax(){
            int max = heap[1];
            heap[1] = heap[capacity];
            this.capacity--;
            siftDown(1);
            return max;
        }
    }

    KthLargest.MaxHeap myheap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.myheap = new MaxHeap();
        this.k = k;
        for(int num : nums){
            this.myheap.insert(num);
        }
    }
    
    public int add(int val) {
        this.myheap.insert(val);
        int kmax = 0;
        int[] reinsert = new int[k];
        for(int i=0; i<this.k;i++){
            kmax = this.myheap.getMax();
            reinsert[i] = kmax;
        }
        for(int i : reinsert){
            this.myheap.insert(i);
        }
        return kmax;
    }
}