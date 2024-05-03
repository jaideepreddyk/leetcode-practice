import java.util.Scanner;

public class KNearestPoint {
    
    public static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static double euclideanDistance(Coordinate a, Coordinate b){
        double x_term = Math.pow((a.x - b.x), 2);
        double y_term = Math.pow((a.y - b.y), 2);

        return Math.sqrt((x_term + y_term));
    }

    public int[][] kClosest(int[][] points, int k) {
        // min-Heap
        // Coordinate array instead of integer array
        // Instead of value at index comparison in integers case, the comparison here will be euclidean distance
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] points = new int[2][size];
        for(int i=0;i<size;i++){
            points[0][i] = s.nextInt();
            points[1][i] = s.nextInt();
        }
        
    }
}
