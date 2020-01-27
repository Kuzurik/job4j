package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        int[] rsl = machine.change(100, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when100by22() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 1};
        int[] rsl = machine.change(100, 82);
        assertThat(rsl, is(expected));
    }

}
