import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LongestTwoDistSubstring {

    public static int lengthOfLongestSubstringTwoDistinct(String s){
        int max_len, curr_len;
        max_len = curr_len = 0;
        char[] str_arr =s.toCharArray();
        HashMap<Character, Integer> tracker = new HashMap<>();
        for(int i=0; i<str_arr.length; i++){
            if(tracker.containsKey(str_arr[i])){
                tracker.replace(str_arr[i], i);
                curr_len++;
            }
            else if(tracker.size()==2){
                char char_drop = ' ';
                int smallest = str_arr.length;
                for(Map.Entry<Character,Integer> entry:tracker.entrySet()){
                    if(entry.getValue()<smallest){
                        char_drop = entry.getKey();
                        smallest = entry.getValue();
                    }
                }
                tracker.remove(char_drop);
                tracker.put(str_arr[i], i);
                max_len = Math.max(max_len, curr_len);
                curr_len = i - smallest;
            }
            else{
                tracker.put(str_arr[i], i);
                curr_len = i+1;
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
