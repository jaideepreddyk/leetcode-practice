import java.util.ArrayList;

public class KthLargest {

    public class MaxHeap{
        ArrayList<Integer> heap;
        int capacity = 1;

        MaxHeap(){
            heap = new ArrayList<>();
            heap.add(0);
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
            heap.add(num);
            capacity++;
            siftUp(capacity);
        }

        public void siftUp(int index){
            if(parent(index)<1) return;
            int parent_val = heap.get(parent(index));
            int curr_val = heap.get(index);
            if(parent_val<curr_val){
                heap.add(index, parent_val);
                heap.add(parent(index), curr_val);
                siftUp(parent(index));
            }
            return;
        }

        public void siftDown(int index){
            int maxIndex = index;
            int leftIdx = leftChild(index);
            int rightIdx = rightChild(index);
            if(leftIdx<=this.capacity && heap.get(maxIndex)<heap.get(leftIdx)){
                maxIndex = leftIdx;
            }
            if(rightIdx<=this.capacity && heap.get(maxIndex)<heap.get(rightIdx)){
                maxIndex = rightIdx;
            }
            if(maxIndex==index){
                return;
            }
            else{
                //swap elements
                int temp = heap.get(maxIndex);
                heap.set(maxIndex, heap.get(index));
                heap.set(index, temp);
                siftDown(maxIndex);
            }
            return;
        }

        public int getMax(){
            int max = heap.get(1);
            heap.set(1, heap.get(capacity));
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
        for(int i=1; i<=this.k;i++){
            kmax = this.myheap.getMax();
            this.myheap.insert(kmax);
        }
        return kmax;
    }
}