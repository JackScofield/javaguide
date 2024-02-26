package laicode.Sort;

import java.util.Random;

public class Utils {

    public static void swap(int[] array, int left, int right){
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }


    public static void printArray(int[] numbers){
        for(int i = 0;i<numbers.length-1;i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.print(numbers[numbers.length-1] + "\n");
    }

    public static int[] getNumbers(int num) {
        Random rand = new Random();
        int[] numbers = new int[num];
        for(int i = 0;i<numbers.length;i++){
            numbers[i] = rand.nextInt(100);
        }
        return numbers;
    }

}
