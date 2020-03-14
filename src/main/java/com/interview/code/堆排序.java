package com.interview.code;

public class 堆排序 {

    //比较的非叶子节点,大顶堆
    public static void sort(int[] array, int index, int length) {
        if (index < 0) {
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        //左节点>根
        if (left < length && array[index] < array[left]) {
            swap(index, left, array);
        }
        //右节点>根
        if (right < length && array[index] < array[right]) {
            swap(index, right, array);
        }
        sort(array, index - 1, length);
    }
    //比较的非叶子节点,小顶堆
    public static void sort1(int[] array, int index, int length) {
        if (index < 0) {
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        //左节点>根
        if (left < length && array[index] > array[left]) {
            swap(index, left, array);
        }
        //右节点>根
        if (right < length && array[index] > array[right]) {
            swap(index, right, array);
        }
        sort1(array, index - 1, length);
    }

    public static void swap(int source, int target, int[] arr) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

    public static void main(String[] args) {
        int[] a = {45, 4, 1, 2, 3, 6, 8, 9, 64, 23, 43, 12};
        int length = a.length;
        while (length > 0) {
            sort1(a, length / 2 - 1, length);
            //最 大/小 值交换
            swap(0, length - 1, a);
            length--;
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

}
