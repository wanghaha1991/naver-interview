package com.interview.code.P1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Sorted {


    public List<Integer> getOrder(int n, int m, List<List<Integer>> edges) {
        LinkedList<Integer> results = new LinkedList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (List<Integer> list : edges){
            Integer node = list.get(1);
            if (map.containsKey(node)){
                map.get(node).add(list.get(0));
            }else {
                LinkedList<Integer> ors = new LinkedList<>();
                ors.add(list.get(0));
                map.put(node, ors);
            }
        }
        //find root
        List<Integer> origins = edges.stream().map(list -> list.get(0))
            .collect(Collectors.toList());

        Set<Integer> roots = origins.stream().filter(node -> !map.containsKey(node))
            .collect(Collectors.toSet());


        results.addAll(roots);
        return results;
    }
}

