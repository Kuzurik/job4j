package ru.job4j.iterator.iteratorconvert;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConverter {

            public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
            return new Iterator<Integer>() {

                private Iterator<Integer> tmp = it.next();


                @Override
                public boolean hasNext() {
                    while (it.hasNext() && !tmp.hasNext()) {
                        tmp = it.next();
                    }
                    return tmp.hasNext();
                }

                @Override
                public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return tmp.next();
                }
            };
        }
    }
