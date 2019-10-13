package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (Task tsk : tasks) {
                int value = tsk.getPriority() > task.getPriority() ? 1 : -1;
                if (value == 1) {
                    tasks.addFirst( task);
                    break;
                }else {
                    tasks.addLast(task);
                    break;
                }

            }
        }

    }



    public Task take() {
        return this.tasks.poll();
    }
}
