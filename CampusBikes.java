import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CampusBikes {

    public static int computeManhattanDistance(int[] p1, int[] p2){
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];

        return Math.abs(x1 - x2) + Math.abs(y1-y2);
    }
    public static int minManhattanDistance(int[][] workers, int[][] bikes){
        int sum = 0;
        ArrayList<Integer> bikes_tracker = new ArrayList<>();
        
        for(int i=0; i<bikes.length; i++){
            bikes_tracker.add(i);
        }
        
        for(int i=0; i<workers.length; i++){
            int min = Integer.MAX_VALUE;
            int remove_idx = 0;
            for(int j=0; j<bikes_tracker.size();j++){
                int dist = computeManhattanDistance(workers[i], bikes[bikes_tracker.get(j)]);
                if(dist<min){
                    min = dist;
                    remove_idx = j;
                }
            }
            bikes_tracker.remove(remove_idx);
            sum += min;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        // WORKERS
        System.out.println("enter number of workers");
        int worker_count = s.nextInt();
        int[][] workers = new int[worker_count][2];
        System.out.println("Enter worker coordinates");
        for(int i=0; i<worker_count; i++){
            for(int j=0; j<2; j++){
                workers[i][j] = s.nextInt();
            }
        }
        // BIKES
        System.out.println("enter number of bikes");
        int bikes_count = s.nextInt();
        int[][] bikes = new int[bikes_count][2];
        System.out.println("Enter bike coordinates");
        for(int i=0; i<bikes_count; i++){
            for(int j=0; j<2; j++){
                bikes[i][j] = s.nextInt();
            }
        }

        System.out.println(minManhattanDistance(workers, bikes));
    }
}
