import java.util.Arrays;
import java.util.Scanner;

public class KokoEatsBananas {

    public static int kokoSpeed(int[] piles, int h){
        long total = totalBananas(piles);
        int lower = (int)(total/h) ;
        int upper = speedLimit(piles);
        int mid = 0;
        int min = 0;
        while(lower<=upper){
            mid = (upper + lower)/2;
            long sim_result = simulateSpeed(piles, h, mid);
            if(sim_result == total){
                upper = mid - 1;
                min = mid;
            }
            else if(sim_result<total){
                lower = mid + 1;
            }
        }
        return min;
    }
    
    public static long simulateSpeed(int[] input, int h, int k){
        int[] piles = input.clone();
        long total = 0;
        int i = 0;
        int counter = 0;
        while(counter<h && i<piles.length){
            if(piles[i]>k){
                total += (piles[i]/k)*k;
                counter += piles[i]/k;
                piles[i] = piles[i] % k;
                if(counter>h){
                    return 0;
                }
                if(piles[i]==0){
                    i++;
                }
            }
            else if(piles[i]<=k){
                total += piles[i];
                i++;
                counter ++;
            }
        }
        return total;
    }


    public static long totalBananas(int[] piles){
        long sum = 0;
        for(int i = 0; i<piles.length; i++){
            sum += piles[i];
        }
        return sum;
    }
    
    // this the maximum speed at which KoKo will be able to eat bananas = maximum value in the pile. 
    // Any value more than that is useless because we are aiming for the minimum speed anyways, and koko eats only 1 pile per hour
    public static int speedLimit(int[] piles){
        int max = 0;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        // piles size
        int n = s.nextInt();
        // hours
        int h = s.nextInt();
        int[] piles = new int[n];
        for(int i = 0; i<n; i++){
            piles[i] = s.nextInt();
        }
        System.out.println(kokoSpeed(piles, h));
    }
}
