package ru.job4j.sorting;


import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
    int result = 0;
    int range = Math.min(left.length(), right.length());
        for (int i = 0; i != range; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}
