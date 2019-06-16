package ru.job4j.array;

/**
 * checking pref for true or false.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayChar {

    /**
     * Check checks that the word starts with the prefix.
     * @param word word to be checked
     * @param prefix prefix to be checked
     * @return boolean true or false
     */

    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int index = 0; index != pref.length; index++) {
            if (pref[index] != wrd[index]) {
                result = false;
            }
        }

        return result;
    }
}