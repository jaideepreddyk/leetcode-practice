import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

public class GenerateParentheses{
    
    static List<String> convertToStrings(List<StringBuilder> input){
        List<String> output= new ArrayList<>();
        for(StringBuilder i : input){
            output.add(i.toString());
        }
        return output;
    }

    static List<StringBuilder> removeDuplicates(List<StringBuilder> input){
        List<String> stringed= new ArrayList<>();
        List<StringBuilder> no_dupes= new ArrayList<>();
        for(StringBuilder i : input){
            if(stringed.contains(i.toString())){}
            else{
                stringed.add(i.toString());
                no_dupes.add(i);
            }
        }
        return no_dupes;
    }

    public static List<String> generateParenthesis(int n) {
        List<StringBuilder> parentheses= new ArrayList<>();
        StringBuilder base = new StringBuilder("()");
        parentheses.add(base);
        
        for(int i=1; i<n; i++){
            List<StringBuilder> new_parentheses= new ArrayList<>();
            for(int j=0; j<parentheses.size(); j++){
                StringBuilder curr = parentheses.get(j);
                for(int k=0; k<curr.length(); k++){
                    StringBuilder newstring = new StringBuilder(curr.toString());
                    newstring.insert(k, "()");
                    new_parentheses.add(newstring);
                }
            }
            parentheses = removeDuplicates(new_parentheses);
        }
        List<String> output = convertToStrings(parentheses);
        return output;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        List<String> output= generateParenthesis(s.nextInt());
        System.out.println(output);
    }
}