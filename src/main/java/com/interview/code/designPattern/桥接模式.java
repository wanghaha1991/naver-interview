package com.interview.code.designPattern;

public class 桥接模式 {

    public abstract class Shape{
        Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public abstract void draw();
    }
    public interface Color{
        public void bePaint(String shape);
    }

    public class Red implements Color{
        public void bePaint(String shape){
            System.out.println("红色的"+shape);
        }
    }

    public class White implements Color{
        public void bePaint(String shape){
            System.out.println("白色的"+shape);
        }
    }

    public class Circle extends Shape{

        @Override
        public void draw() {
            color.bePaint("圆形");
        }
    }

    public class Rectangle extends Shape{

        @Override
        public void draw() {
            color.bePaint("长方形");
        }
    }

    public static void main(String[] args) {
//        Red red = new Red();
//        Rectangle rectangle = new Rectangle();
//        rectangle.setColor(red);
//        rectangle.draw();

    }


}
