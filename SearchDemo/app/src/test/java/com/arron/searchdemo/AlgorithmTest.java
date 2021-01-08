package com.arron.searchdemo;

import org.junit.Test;

import java.util.Arrays;

/**
 * create by Aaron Xie
 * on 2021/1/6
 * description:
 */
public class AlgorithmTest {

    @Test
    public void bubbleSort() {
        int[] arr = {5, 3, 6, 4, 0, 10, 5, 8, 7, 1};
        int[] bubbleSort = getBubbleSort(arr);
        System.out.println(Arrays.toString(bubbleSort));
    }

    private int[] getBubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void selectSort() {
        int[] arr = {5, 3, 6, 4, 0, 10, 5, 8, 7, 1};
        int[] bubbleSort = getSelectSort(arr);
        System.out.println(Arrays.toString(bubbleSort));
    }

    private int[] getSelectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    @Test
    public void insertSort() {
        int[] arr = {5, 3, 6, 4, 0, 10, 5, 8, 7, 1};
        int[] bubbleSort = getInsertSort(arr);
        System.out.println(Arrays.toString(bubbleSort));
    }

    private int[] getInsertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void quickSort() {
        int[] arr = {5, 3, 6, 4, 0, 10, 5, 8, 7, 1};
        int[] bubbleSort = getQuickSort(arr);
        System.out.println(Arrays.toString(bubbleSort));
    }

    private int[] getQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        if (lowIndex >= highIndex) {
            return arr;
        }
        sort(arr, lowIndex, highIndex);
        return arr;
    }

    private void sort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int index = getIndex(arr, lowIndex, highIndex);
            sort(arr, lowIndex, index - 1);
            sort(arr, index + 1, highIndex);
        }
    }

    private int getIndex(int[] arr, int lowIndex, int highIndex) {
        int temp = arr[lowIndex];
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && arr[highIndex] >= temp) {
                highIndex--;
            }
            arr[lowIndex] = arr[highIndex];
            while (lowIndex < highIndex && arr[lowIndex] <= temp) {
                lowIndex++;
            }
            arr[highIndex] = arr[lowIndex];
        }
        arr[lowIndex] = temp;
        return lowIndex;
    }

    @Test
    public void search() {
        int[] arr = {5, 3, 6, 4, 0, 10, 5, 8, 7, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = getTarget(arr, 5);
        System.out.println(target);
    }

    private int getTarget(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int low = 0;
        int high = arr.length;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value < arr[mid]) {
                high = mid - 1;
            } else if (value > arr[mid]) {
                low = mid + 1;
            } else {
                result = mid;
                low = mid + 1;//查找最后一个
            }
        }
        return result;
    }
}
