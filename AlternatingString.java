import java.util.Scanner;

public class AlternatingString {
    public static int minOperations(String s) {
        if(s.length()==1) return 0;
        char[] str_arr = s.toCharArray();
        if(s.length()==2){
            if(str_arr[0]==str_arr[1]) return 1;
        }
        // creating solutions
        int arr_len = s.length()+(s.length()%2);
        String sol_1, sol_2;
        sol_1 = sol_2 = "";

        for(int i =0; i<arr_len/2;i++){
            sol_1 = sol_1 + "10";
            sol_2 = sol_2 + "01";
        }

        char[] sol1_arr = sol_1.toCharArray();
        char[] sol2_arr = sol_2.toCharArray();
        
        int counter1, counter2;
        counter1 = counter2 = 0;
        for(int i = 0; i<str_arr.length; i++){
            if(str_arr[i]!=sol1_arr[i]) counter1++;
            else if(str_arr[i]!=sol2_arr[i]) counter2++;
        }
        return Math.min(counter1, counter2);
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(minOperations(input));
    }
}
