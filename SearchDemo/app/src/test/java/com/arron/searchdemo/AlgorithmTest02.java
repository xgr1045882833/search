package com.arron.searchdemo;

import org.junit.Test;

import java.util.Arrays;

/**
 * create by Aaron Xie
 * on 2021/3/16
 * description:
 */
public class AlgorithmTest02 {

    @Test
    public void bubbleSort() {
        int[] arr = {3, 5, 7, 1, -4, 7, 100, 6};
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
        int[] arr = {3, 5, 7, 1, -4, 7, 100, 6};
        int[] selectSort = getSelectSort(arr);
        System.out.println(Arrays.toString(selectSort));
    }

    private int[] getSelectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
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
        int[] arr = {3, 5, 7, 1, -4, 7, 100, 6};
        int[] insertSort = getInsertSort(arr);
        System.out.println(Arrays.toString(insertSort));
    }

    private int[] getInsertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int insertNote = arr[i];//待插入的数
            int j = i - 1;
            while (j >= 0 && insertNote < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNote;
        }
        return arr;
    }

    @Test
    public void quickSort() {
        int[] arr = {3, 5, 7, 1, -4, 7, 100, 6};
        int[] quickSort = getQuickSort(arr);
        System.out.println(Arrays.toString(quickSort));
    }

    private int[] getQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        return getTargetSort(0, arr.length - 1, arr);
    }

    private int[] getTargetSort(int lowIndex, int heighIndex, int[] arr) {
        if (lowIndex < heighIndex) {
            int middle = getMiddle(arr, lowIndex, heighIndex);
            getTargetSort(lowIndex, middle - 1, arr);
            getTargetSort(middle + 1, heighIndex, arr);
        }
        return arr;
    }

    private int getMiddle(int[] arr, int lowIndex, int heighIndex) {
        int temp = arr[lowIndex];
        while (lowIndex < heighIndex) {
            while (lowIndex < heighIndex && temp <= arr[heighIndex]) {
                heighIndex--;
            }
            arr[lowIndex] = arr[heighIndex];
            while (lowIndex < heighIndex && arr[lowIndex] <= temp) {
                lowIndex++;
            }
            arr[heighIndex] = arr[lowIndex];
        }
        arr[lowIndex] = temp;
        return lowIndex;
    }

    @Test
    public void search() {
        int[] arr = {3, 5, 7, 1, -4, 7, 100, 6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = getTargetIndex(arr, 7);
        System.out.println("要查找的数字在第" + (target + 1) + "个");
    }

    private int getTargetIndex(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int low = 0;
        int heigh = arr.length - 1;
        while (low <= heigh) {
            int mid = (low + heigh) / 2;
            if (target < arr[mid]) {
                heigh = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
