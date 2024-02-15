package org.example.sort;

import java.util.Random;

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

    private static void swap(int[] array, int left, int right){
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
    private static void printArray(int[] numbers){
        for(int i = 0;i<numbers.length-1;i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.print(numbers[numbers.length-1] + "\n");
    }
    public static void main(String[] args){
        Random rand = new Random();
        int[] numbers = new int[10];
        for(int i = 0;i<numbers.length;i++){
            numbers[i] = rand.nextInt(100);
        }
        System.out.println("Before");
        printArray(numbers);
        quickSort(numbers);
        System.out.println("\nAfter");
        printArray(numbers);
    }
}
