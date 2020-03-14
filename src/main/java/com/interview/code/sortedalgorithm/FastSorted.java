package com.interview.code.sortedalgorithm;

public class FastSorted {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 6, 5, 7, 2, 9, 0};
        quickSort(0, array.length - 1, array);
        System.out.println(array);

    }

    public static void quickSort(int left, int right, int[] array) {
        int i = left, j = right, temp = array[left];

        if (left >= right) {
            return;
        }
        while (i < j) {
            //从右向左找
            while (i < j && array[j] > temp) {
                j--;
            }
            array[i] = array[j];
            array[j] = temp;
            //从左向右找
            while (i < j && array[i] < temp) {
                i++;
            }
            array[j] = array[i];
            array[i] = temp;
        }
        quickSort(left, i - 1, array);
        quickSort(i + 1, right, array);
    }

}
