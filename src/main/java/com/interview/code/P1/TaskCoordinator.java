package com.interview.code.P1;

import com.interview.code.P1.OrderedTask;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskCoordinator {

    public static LinkedList<OrderedTask> tasks = new LinkedList<>();

    public void addTask(OrderedTask task){
        tasks.add(task);
    }

    public static void runTasks(){
        LinkedList<OrderedTask> orderedTasks = new LinkedList<>();
        //find root
        Set<OrderedTask> rootTasks = tasks.stream().
            filter(task -> task.getNext() == null).collect(Collectors.toSet());
        orderedTasks.addAll(rootTasks);

        HashSet<OrderedTask> dones = new HashSet<>();
        dones.addAll(rootTasks);

        List<OrderedTask> nextTasks = rootTasks.stream().map(task -> task.getNext())
            .filter(Objects::nonNull)
            .flatMap(list -> list.stream()).collect(Collectors.toList());


        while (!nextTasks.isEmpty()){
            OrderedTask nextTask = nextTasks.get(1);
            ArrayList<OrderedTask> pres = nextTask.getPres();
            //check pres
            boolean allDone = true;
            for (OrderedTask t : pres){
                if (!dones.contains(t)){
                    allDone = false;
                }
            }
            //add to tail
            if (!allDone){
                nextTasks.remove(nextTask);
                nextTasks.add(nextTask);
                continue;
            }
            dones.add(nextTask);
            if (nextTask.getNext().isEmpty()){
                continue;
            }
            nextTasks.remove(nextTask);
            nextTasks.addAll(nextTask.getNext());
        }

    }
}
