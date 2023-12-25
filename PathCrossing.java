import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

public class PathCrossing {
    class Coordinates{
        int x;
        int y;
        Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Coordinates obj){
            if(this==obj)return true;
            else if(this.x==obj.x && this.y==obj.y)return true;
            return false;
        }
    }
    public static boolean isPathCrossing(String path) {
        int x=0;
        int y=0;
        HashSet<String> set = new HashSet<>();
        String combined_str = Integer.toString(x)+','+Integer.toString(y);
        set.add(combined_str);
        char[] input = path.toCharArray();
        for(int i=0; i<path.length(); i++){
            if(input[i]=='N') y+=1;
            else if(input[i]=='S') y-=1;
            else if(input[i]=='E') x+=1;
            else if(input[i]=='W') x-=1;
            combined_str = Integer.toString(x)+','+Integer.toString(y);
            if(set.contains(combined_str))return true;
            else set.add(combined_str);
        }
        return false;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        System.out.println(isPathCrossing(path));
    }
}
