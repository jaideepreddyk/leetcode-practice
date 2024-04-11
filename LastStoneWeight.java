import java.util.Scanner;

public class LastStoneWeight {

    public class MaxHeap{
        int[] heap;
        int capacity = 0;
        MaxHeap(){
            this.heap = new int[30];
        }
        MaxHeap(int[] arr){
            this.heap = arr;
            this.capacity = arr.length;
            if(arr.length>1){
                this.BuildHeap();
            }
        }

        public int parent(int index){
            return (index-1)/2;
        }

        public int leftChild(int index){
            return (2*index)+1;
        }

        public int rightChild(int index){
            return (2*index)+2;
        }

        public void BuildHeap(){
            int start_pos = (this.capacity/2)-1;
            for(int i=start_pos;i>=0;i--){
                this.siftDown(i);
            }
        }
        public void insert(int num){
            heap[capacity] = num;
            siftUp(capacity);
            this.capacity++;
            return;
        }

        public void siftUp(int index){
            if(parent(index)<0) return;
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
            if(leftIdx<this.capacity && heap[maxIndex]<heap[leftIdx]){
                maxIndex = leftIdx;
            }
            if(rightIdx<this.capacity && heap[maxIndex]<heap[rightIdx]){
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
            int max = heap[0];
            heap[0] = heap[capacity-1];
            this.capacity--;
            siftDown(0);
            return max;
        }
    }

    public int lastStoneWeight(int[] stones){
        LastStoneWeight.MaxHeap maxheap = new MaxHeap(stones);
        while(maxheap.capacity>1){
            int first = maxheap.getMax();
            int second = maxheap.getMax();
            if (first-second > 0){
                maxheap.insert(first-second);
            }
        }
        if(maxheap.capacity==0){
            return 0;
        }
        else{
            return maxheap.heap[0];
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] stones = new int[len];
        for(int i=0; i<len;i++){
            stones[i] = s.nextInt();
        }
        LastStoneWeight sol = new LastStoneWeight();
        System.out.println(sol.lastStoneWeight(stones));
    }

}
