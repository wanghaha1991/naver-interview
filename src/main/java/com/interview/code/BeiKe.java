package com.interview.code;


import java.util.Scanner;

public class BeiKe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long start = 1;
        long end = n;
        long temp = 0;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (minNum(mid, n)) {
                temp = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(temp);
    }

    private static boolean minNum(long m, long n) {
        long temp = n;
        long mid = 0;
        long num1 = 0;
        while (temp >= 0) {
            if (temp < m) {
                num1 += temp;
                break;
            }
            num1 += m;
            temp -= m;
            temp -= temp / 10;
        }
        if (n % 2 == 0) {
            mid = n / 2;
        } else {
            mid = (n + 1) / 2;
        }

        return num1 >= mid ? true : false;
    }
}