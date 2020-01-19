package ru.job4j.lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class FunctionCountingTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCounting fun = new FunctionCounting();
        List<Double> result = fun.diapason(3, 6, x -> 3 * x + 2);
        List<Double> expected = List.of(11D, 14D, 17D);
        assertThat(expected, is(result));
    }

    @Test
    public void whenSquareFunctionThenSquareResult() {
        FunctionCounting fun = new FunctionCounting();
        List<Double> result = fun.diapason(3, 6, x -> Math.pow(2 * x, 2) + (2 * x) + 3);
        List<Double> expected = List.of(45D, 75D, 113D);
        assertThat(expected, is(result));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResult() {
        FunctionCounting fun = new FunctionCounting();
        List<Double> result = fun.diapason(3, 6, x -> Math.log(x));
        List<Double> expected =List.of(Math.log(3D), Math.log(4D), Math.log(5D));
        assertThat(expected, is(result));
    }
}
