import java.util.Scanner;
import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s){
        if(s.length()<2) return false;
        char[] brackets = s.toCharArray();
        Stack<Character> open_brackets = new Stack<>();
        for(char c : brackets){
            if(c=='}' && open_brackets.size()>0){
                if('{'==open_brackets.pop()){}
                else return false;
            }
            else if(c==']' && open_brackets.size()>0){
                if('['==open_brackets.pop()){}
                else return false;
            }
            else if(c==')' && open_brackets.size()>0){
                if('('==open_brackets.pop()){}
                else return false;
            }
            else open_brackets.push(c);
        }
        if(open_brackets.size()>0) return false;
        return true;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(isValid(input));
    }
}
