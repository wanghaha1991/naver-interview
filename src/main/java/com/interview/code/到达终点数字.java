package com.interview.code;

/*
在一根无限长的数轴上，你站在0的位置。终点在target的位置。

每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。

返回到达终点需要的最小移动次数。

思路：每一步的绝对值大小的递增的，1+2+3+.....+n
只是每一个数的符号不同，那么结果就是 sum = n(n+1)/2
其中整数和设置为:p  负数和设置为: q
p+q =s
p-q = target
s -target = 2q >= 0
所以可知:n(n+1)/2-target肯定是偶数且大于等于0
 */
public class 到达终点数字 {

    public int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }
        int n = 0;
        int sum = 0;
        while (true) {
            if (sum >= target && (sum - target) % 2 == 0) {
                return n;
            }
            n++;
            sum += n;
        }
    }
}
