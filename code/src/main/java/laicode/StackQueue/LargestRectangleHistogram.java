package laicode.StackQueue;

import java.util.*;

public class LargestRectangleHistogram {
    public static int largest(int[] array) {
        // Write your solution here
        int res = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<=array.length;i++){
            int cur = i == array.length ? 0 : array[i];
            while(!stack.isEmpty() && array[stack.peekFirst()] >= cur){
                int height = array[stack.pollFirst()];
                int left= stack.isEmpty() ? 0 : stack.peekFirst()+1;
                res = Math.max(res,height * (i-left));
            }
            stack.offerFirst(i);
        }
        return res;
    }

    public static void main(String[] args){
        int[] array = {2,1,3,3,4};
        System.out.println(largest(array));
    }
}
