import java.util.Scanner;

public class KNearestPoint {

    public class MaxHeap{
        int[][] heap;
        int capacity = 0;
        MaxHeap(){
            this.heap = new int[10000][2];
        }
        MaxHeap(int[][] arr){
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
        public void insert(int[] point){
            heap[capacity] = point;
            siftUp(capacity);
            this.capacity++;
            return;
        }

        public void siftUp(int index){
            if(parent(index)<0) return;
            int[] origin = {0,0};
            int[] parent_val = heap[parent(index)];
            int[] curr_val = heap[index];
            if(euclideanDistance(parent_val, origin) < euclideanDistance(curr_val, origin)){
                heap[index] = parent_val;
                heap[parent(index)] = curr_val;
                siftUp(parent(index));
            }
            return;
        }

        public void siftDown(int index){
            int[] origin = {0,0};
            int maxIndex = index;
            int leftIdx = leftChild(index);
            int rightIdx = rightChild(index);
            if(leftIdx<this.capacity && euclideanDistance(heap[maxIndex], origin) < euclideanDistance(heap[leftIdx], origin)){
                maxIndex = leftIdx;
            }
            if(rightIdx<this.capacity && euclideanDistance(heap[maxIndex], origin) < euclideanDistance(heap[rightIdx], origin)){
                maxIndex = rightIdx;
            }
            if(maxIndex==index){
                return;
            }
            else{
                //swap elements
                int[] temp = heap[maxIndex];
                heap[maxIndex]= heap[index];
                heap[index] = temp;
                siftDown(maxIndex);
            }
            return;
        }

        public int[] getMax(){
            int[] max = heap[0];
            heap[0] = heap[capacity-1];
            this.capacity--;
            siftDown(0);
            return max;
        }
    }
    
    public static double euclideanDistance(int[] a, int[] b){
        double x_term = Math.pow((a[0] - b[0]), 2);
        double y_term = Math.pow((a[1] - b[1]), 2);

        return Math.sqrt((x_term + y_term));
    }

    public int[][] kClosest(int[][] points, int k) {
        // min-Heap
        // Coordinate array instead of integer array
        // Instead of value at index comparison in integers case, the comparison here will be euclidean distance

        int[][] solution = new int[k][2];
        MaxHeap coordinates = new MaxHeap(points);
        
        for(int i=0; i<k;i++){
            solution[k] = coordinates.getMax();
        }

        return solution;

    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] points = new int[size][2];
        for(int i=0;i<size;i++){
            points[i][0] = s.nextInt();
            points[i][1] = s.nextInt();
        }
        
    }
}
