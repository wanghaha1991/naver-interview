package com.interview.code.LeetCode;

import java.util.Stack;

public class 用两个栈实现队列 {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();


    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()){
            return out.pop();
        }
        if (!in.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }
        return -1;
    }


}
