package ru.job4j.generator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;

public class GeneratorTest {

    @Test
    public void whenGenerateString() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("name", "alex", "subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(template, args);
        String expected = "I am a alex, Who are you?";
        assertThat(expected, is(result));
    }

    @Test
    public void henNoEnoughArgsThenException() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        try {
            String result = generator.produce(template, args);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            System.out.println(thrown.getMessage());
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void whenNotArgsThenException() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = new HashMap<>();
        String template = "I am a ${name}, Who are ${subject}?";
        try {
            String result = generator.produce(template, args);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            System.out.println(thrown.getMessage());
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void whenNotKeyThenException() {
        Generator generator = new SimpleGenerator();
        Map<String, String> args = Map.of("text", "alex", "subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        try {
            String result = generator.produce(template, args);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            System.out.println(thrown.getMessage());
            assertNotEquals("", thrown.getMessage());
        }
    }
}
