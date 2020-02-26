package com.interview.code.P1;

import java.util.ArrayList;

public class OrderedTask {
    private ArrayList<OrderedTask> nexts;
    private ArrayList<OrderedTask> pres;

    public void doRun(){

    }


    public void setNext(OrderedTask nextTask) {
        if (nexts == null){
            nexts = new ArrayList<OrderedTask>();
        }
        nexts.add(nextTask);
    }
    public ArrayList<OrderedTask> getNext(){
        return nexts;
    }
    public void setPres(OrderedTask preTask) {
        if (nexts == null){
            nexts = new ArrayList<OrderedTask>();
        }
        nexts.add(preTask);
    }
    public ArrayList<OrderedTask> getPres(){
        return pres;
    }
}
