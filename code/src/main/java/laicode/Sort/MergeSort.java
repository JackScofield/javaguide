package laicode.Sort;

import java.util.Random;

import static laicode.Sort.Utils.printArray;

public class MergeSort {

    public static void mergeSort(int[] array){
        if(array == null || array.length <2){
            return;
        }
        int midIndex = array.length/2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[array.length-midIndex];

        for(int i = 0;i<midIndex;i++){
            leftArray[i] = array[i];
        }
        for(int i = midIndex;i<array.length;i++){
            rightArray[i-midIndex] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array,leftArray,rightArray);
    }
    private static void  merge(int[] array, int[] leftArray, int[] rightArray){
        int n = leftArray.length + rightArray.length;
        int lp = 0;
        int rp = 0;

        int index = 0;
        while(lp< leftArray.length && rp < rightArray.length){
            if(leftArray[lp]<=rightArray[rp]){
                array[index] = leftArray[lp];
                lp++;
            }
            else{
                array[index] = rightArray[rp];
                rp++;
            }
            index++;
        }
        while(lp<leftArray.length){
            array[index] = leftArray[lp];
            lp++;
            index++;
        }
        while(rp<rightArray.length) {
            array[index] = rightArray[rp];
            rp++;
            index++;
        }
    }

    public static void main(String[] args){
        int[] numbers = Utils.getNumbers(100);
        System.out.println("Before");
        printArray(numbers);
        mergeSort(numbers);
        System.out.println("\nAfter");
        printArray(numbers);
    }
}
