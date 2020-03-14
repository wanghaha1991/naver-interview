package com.interview.code.P1;

public class erfen {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(7, array));
    }

    public static int binarySearch(int target, int[] array) {
        int left = 0, right = array.length - 1;


        if (target>array[right] || target < array[left]){
            return -1;
        }

        for (;;) {
            int mid = (right + left) / 2;

            if (left >= right){
                return -1;
            }
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                right = mid;
            }
            if (array[mid] < target) {
                left = mid;
            }
        }
    }

}
