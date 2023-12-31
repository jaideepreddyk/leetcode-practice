import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestTwoSubstringOptimal {

    public static int lengthOfLongestSubstringTwoDistinct(String s){
        int max_len, curr_len;
        max_len = curr_len = 0;
        char[] str_arr =s.toCharArray();
        //track characters
        char[] char_tracker = new char[2];
        //track position
        int[] pos_tracker = new int[2];

        // loop over elements
        for(int i=0; i<str_arr.length; i++){

            // add if not present
            if(char_tracker[0]==0){
                char_tracker[0]=str_arr[i];
            }
            else if(char_tracker[1]==0 && char_tracker[0]!=str_arr[i]){
                char_tracker[1]=str_arr[i];
            }
            // if matches with available character
            if(char_tracker[0]==str_arr[i]){
                pos_tracker[0] = i; 
                curr_len++;
            }
            else if(char_tracker[1]==str_arr[i]){
                pos_tracker[1] = i; 
                curr_len++;
            }
            else{
                int min_idx;
                if(pos_tracker[0]<pos_tracker[1])min_idx = 0;
                else min_idx = 1;
                //savepoint for the current length because it will update after new character
                max_len = Math.max(max_len, curr_len);
                // length resets here after switching to new character
                curr_len = i - pos_tracker[min_idx];
                char_tracker[min_idx] = str_arr[i];
                pos_tracker[min_idx] = i;
            }
        }
        return Math.max(max_len, curr_len);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(lengthOfLongestSubstringTwoDistinct(input));
    }
}
