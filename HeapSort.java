import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static class Heap{
        int size;
        int max_size;
        int[] heap;
        //constructor
        public Heap(int[] arr){
            this.size = this.max_size = arr.length;
            this.heap = arr;
        }
        public Heap(int[] arr, int size){
            this.size = size;
            this.max_size = arr.length;
            this.heap = arr;
        }
        // return parent index
        public int parent(int curr_idx){
            return (curr_idx/2) -1;
        }
        //left child
        public int leftChild(int curr_idx){
            return (2*curr_idx)+1;
        }
        //right child
        public int rightChild(int curr_idx){
            return (2*curr_idx)+2;
        }
        // sift down
        // this should be recursive
        private void siftDown(int idx){
            int max_index = idx;
            int left_child = leftChild(idx);
            int right_child = rightChild(idx);
            if(left_child<this.size && this.heap[left_child]>this.heap[max_index]) max_index = left_child;
            if(right_child<this.size && this.heap[right_child]>this.heap[max_index]) max_index = right_child;
            // swap
            int temp = heap[idx];
            heap[idx] = heap[max_index];
            heap[max_index] = temp;

            if(idx!=max_index){
                siftDown(max_index);
            }
        }

        // build heap
        public void buildHeap(){
            for(int i = (size/2)-1; i>=0; i--){
                siftDown(i);
            }
        }
        // extract max
        public int extractMax(){
            int max =  heap[0];
            // swap max and leaf
            heap[0] = heap[size-1];
            heap[size-1] = max;
            // reduce heap size 
            this.size = size - 1;
            // siftdown the root which is currently the leaf after swapping
            siftDown(0);
            return max;
        }
    }

    public static int[] heapSort(int[] arr){
        // build heap first
        Heap heap = new Heap(arr);
        heap.buildHeap();
        // then extract max the length of the friggin array
        for(int i:arr){
            heap.extractMax();
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = s.nextInt();
        }
        int[] sorted_arr = heapSort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }
}
