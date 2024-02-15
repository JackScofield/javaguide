package review;

public class ReOrder {
    public int[] reorder(int[] array) {
        // Write your solution here
        int length = array.length;
        if(length==0 || length==1 || length==2){
            return array;
        }
        int fast = length/2;
        int[] res = new int[length];
        int first = 0;
        int slow=0;
        int second = first+1;
        for(int i =0;i<length/2;i++){
            res[first] = array[slow];
            res[second] = array[fast];
            slow++;
            fast++;
            first+=2;
            second+=2;
        }
        if(length%2==1){
            res[first] = array[length-1];
        }
        return res;
    }
}
