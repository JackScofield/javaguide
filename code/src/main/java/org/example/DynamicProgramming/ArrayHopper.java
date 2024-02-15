package DynamicProgramming;

public class ArrayHopper {
    public static int minJump(int[] array) {
        // Write your solution here
        int length = array.length;
        int[] minJump = new int[length];
        minJump[0] = 0;
        for (int i = 1; i < length; i++) {
            minJump[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[length - 1];
    }
}