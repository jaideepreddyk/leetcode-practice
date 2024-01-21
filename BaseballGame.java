import java.util.Scanner;
import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] operations){
        int total=0;
        Stack<Integer> scores = new Stack<>();
        for(String op:operations){
            switch (op) {
                case "C":
                    scores.pop();
                    break;
                case "D":
                    scores.push(scores.peek()*2);
                    break;
                case "+":
                    int one = scores.get(scores.size()-1);
                    int two = scores.get(scores.size()-2);
                    scores.push(one+two);
                    break;
                default:
                    scores.push(Integer.parseInt(op));
                    break;
            }
        }
        for(int x:scores){
            total+=x;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String[] ops = new String[size];
        for(int i=0; i<size; i++){
            ops[i] = s.next();
        }
        System.out.println(calPoints(ops));
    }
}
