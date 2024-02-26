package laicode.Sort;

import static laicode.Sort.Utils.printArray;

public class SelectSort {
    public static void selectSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }
        for(int i = 0;i<array.length;i++){
            int curMin = array[i];
            int index = i;
            for(int j = i+1;j<array.length;j++){
                if(curMin > array[j]){
                    curMin = array[j];
                    index = j;
                }
            }
            Utils.swap(array,i,index);
        }
    }
    public static void main(String[] args){

        int[] numbers = Utils.getNumbers(16);

        System.out.println("Before");
        printArray(numbers);
        selectSort(numbers);
        System.out.println("\nAfter");
        printArray(numbers);
    }
}
