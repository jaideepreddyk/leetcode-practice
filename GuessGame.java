import java.util.Scanner;

public class GuessGame {
    static int pick;

    public static int guessNumber(int n) {
        long left  = 1;
        long right = n;
        int mid;
        while(left<=right){
            mid = (int)((left+right)/2);
            if(guess(mid)==-1){
                right = mid - 1;
            }
            else if(guess(mid)==1){
                left = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static int guess(int num){
        if(num<pick) return 1;
        else if(num>pick)  return -1;
        else return 0;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        pick = s.nextInt();
        System.out.println(guessNumber(n));
    }
}
