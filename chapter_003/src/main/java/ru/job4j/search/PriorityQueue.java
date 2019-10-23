package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {

       if (tasks.size() == 0) {
         tasks.add(task);
       } else {
        int index = 0;
        for (Task tsk : tasks) {
            if (tsk.getPriority() > task.getPriority()) {
                tasks.add(index, task);
                break;
            }
            index++;
       }
    }
}

    public Task take() {
        return this.tasks.poll();
    }
}
