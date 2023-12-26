import java.util.Scanner;

public class AlternatingString {
    public static int minOperations(String s) {
        if(s.length()==1) return 0;
        char[] str_arr = s.toCharArray();        
        if(s.length()==2){
            if(str_arr[0]==str_arr[1]) return 1;
        }

        Boolean bool = true;
        int[] input_arr = new int[s.length()];

        // creating solutions
        int[] sol1_arr = new int[s.length()];
        int[] sol2_arr = new int[s.length()];

        for(int i=0; i<input_arr.length; i++){
            bool = !bool;
            input_arr[i] = Character.getNumericValue(str_arr[i]);

            sol1_arr[i] = bool?1:0;
            sol2_arr[i] = !bool?1:0;
        }

        
        int counter1, counter2;
        counter1 = counter2 = 0;
        for(int i = 0; i<input_arr.length; i++){
            if(input_arr[i]!=sol1_arr[i]) counter1++;
            else if(input_arr[i]!=sol2_arr[i]) counter2++;
        }
        return Math.min(counter1, counter2);
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(minOperations(input));
    }
}
