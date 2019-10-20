package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
            boolean addList = false;
            if (tasks.size() != 0) {
                int index = 0;
                for (Task iTask : tasks) {
                    if (iTask.getPriority() > task.getPriority()) {
                        tasks.add(index, task);
                        addList = true;
                        break;
                    }
                    index++;
                }
            }
                if (!addList) {
                    tasks.addLast(task);
                }

    }



    public Task take() {
        return this.tasks.poll();
    }
}
