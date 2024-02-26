package laicode.Sort;

import static laicode.Sort.Utils.printArray;

public class InsertSort {
    public static void insertSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }
        for(int i = 1;i<array.length;i++){
            int cur = array[i];
            int j = i-1;
            while(j>=0 && array[j]> cur){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = cur;
        }
    }

    public static void main(String[] args){
        int[] numbers = Utils.getNumbers(10);
        System.out.println("Before");
        printArray(numbers);
        insertSort(numbers);
        System.out.println("\nAfter");
        printArray(numbers);
    }
}
