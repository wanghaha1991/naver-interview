package com.interview.code.P1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    public void dfs(Node node){
        ArrayList<Node> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null){
            return;
        }
        //root
        stack.push(node);
        while (!stack.isEmpty()){
            //先右后左
            Node top = stack.pop();
            res.add(top);
            if (top.getRight() != null){
                stack.push(top.getRight());

            }
            if (top.getLeft() != null){
                stack.push(top.getLeft());
            }
        }
        System.out.println(res);
    }

    public void bfs(Node node){
        LinkedList<Node> nodes = new LinkedList<>();
        ArrayList<Node> res = new ArrayList<>();
        nodes.offer(node);
        while (!nodes.isEmpty()){
            Node pop = nodes.poll();
            if (pop == null){
                continue;
            }
            res.add(pop);
            if (pop.getLeft()!=null){
                nodes.offer(pop.getLeft());
            }
            if (pop.getRight()!=null){
                nodes.offer(pop.getRight());
            }
        }
    }

    public class Node{
        private Node left;
        private Node right;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
        public String toString(){
          return name;
        }
    }

}
