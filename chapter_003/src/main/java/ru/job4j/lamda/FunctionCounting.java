package ru.job4j.lamda;


import java.util.ArrayList;
import java.util.List;


public class FunctionCounting {
   public List<Double> diapason(int start, int end, java.util.function.Function<Double, Double> fun) {
       List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++ ) {
            result.add(fun.apply((Double.valueOf(index))));
        }
        return  result;
    }
}
