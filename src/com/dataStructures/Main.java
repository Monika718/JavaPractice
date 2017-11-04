package com.dataStructures;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] generateArray() {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] <= arr[j])
                    break;
                else {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        int[] arr1 = generateArray();
        System.out.println("Input: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        int[] arr2 = generateArray();
        System.out.println("Input: " + Arrays.toString(arr2));
        insertionSort(arr2);
        System.out.println("Insertion Sort: " + Arrays.toString(arr2));

    }
}