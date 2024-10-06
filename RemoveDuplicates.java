public class RemoveDuplicates {

    public int removeDuplicates (int[] arr){
        int placepointer = 0;

        // edge case
        if(arr.length == 1) return 1;
        
        for(int i=1; i<arr.length; i++){
            if (arr[placepointer]!=arr[i]){
                placepointer += 1; // increment pointer
                // swap only if i is ahead of placepointer and not if they are in the same position
                if(i>placepointer){
                    int temp = arr[i];
                    arr[i] = arr[placepointer];
                    arr[placepointer] = temp;
                }
            }
        }

        return placepointer + 1;
    }
    public static void main(String[] args){

    }
}
