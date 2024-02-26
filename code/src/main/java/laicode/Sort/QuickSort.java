package laicode.Sort;

import java.util.Random;

import static laicode.Sort.Utils.*;

public class QuickSort {

    public static void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }

        int pivotIndex = new Random().nextInt(right-left) + left;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,right);
        int lp = partition(array, left, right, pivot);

        quickSort(array,left,lp-1);
        quickSort(array,lp+1,right);
    }

    public static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }
    private static int partition(int[] array, int left, int right, int pivot) {
        int lp = left;
        int rp = right;
        while(lp<rp){
            while(array[lp] <= pivot && lp<rp){
                lp++;
            }
            while(array[rp] >= pivot && lp<rp){
                rp--;
            }
            swap(array,lp,rp);
        }
        swap(array,lp, right);
        return lp;
    }


    public static void main(String[] args){

        int[] numbers = Utils.getNumbers(100);

        System.out.println("Before");
        printArray(numbers);
        quickSort(numbers);
        System.out.println("\nAfter");
        printArray(numbers);
    }
}
