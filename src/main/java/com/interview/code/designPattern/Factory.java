package com.interview.code.designPattern;



//factory pattern
public class Factory {


    public Car getCar(String name){
        if (name == null){
            return null;
        }
        if (name.equals("BMW")){
            return new BMW();
        }
        if (name.equals("Ben")){
            return new Ben();
        }
        return null;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Car ben = factory.getCar("Ben");
    }
}


interface Car{
    public void driver();
}

class BMW implements Car{
    public void driver(){
        System.out.println("BMW");
    }
}

class Ben implements Car{
    public void driver(){
        System.out.println("Ben");
    }
}