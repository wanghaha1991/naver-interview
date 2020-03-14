package com.interview.code;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Sort {

    public static void main(String[] args) {
        int n;
        HashMap<String, ArrayList<Integer>> nameScores = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    String s = sc.nextLine();
                    String[] ss = s.split(" ", 4);
                    for (int j = 0; i < 4; j++) {
                        if (j == 0) {
                            ArrayList<Integer> scores = new ArrayList<>();
                            nameScores.put(ss[0], scores);
                        } else {
                            nameScores.get(ss[0]).add(Integer.parseInt(ss[j]));
                        }
                    }
                }
            }
            Map<String, Integer> mapTotal = new HashMap<>();

            for (String name : nameScores.keySet()) {
                int sum = 0;
                for (Integer score : nameScores.get(name)){
                    sum +=score;
                }
                mapTotal.put(name, sum);
            }
            ValueComparator bvc =  new ValueComparator(mapTotal);
            //按照value降序
            Map<String, Integer> mapTotals = new TreeMap<>(bvc);
            mapTotal.putAll(mapTotal);
            for (String name : mapTotals.keySet()){
                System.out.println(name + nameScores.get(name));
            }

        } catch (Exception e) {
            System.out.println("input error");
        }


    }

    static class ValueComparator implements Comparator<String> {

        Map<String, Integer> base;
        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) > base.get(b)) {
                return -1;
            } else if(base.get(a) < base.get(b)) {
                return 1;
            }else {
                return 0;
            }
        }
    }
}
