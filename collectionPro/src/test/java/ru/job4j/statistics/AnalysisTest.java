package ru.job4j.statistics;

import org.junit.Test;

import ru.job4j.statistics.Analysis;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    @Test
    public void whenOneAddedOneDeletedOneChanged() {
        Analysis.User firstUser = new Analysis.User(1, "1");
        Analysis.User secondUser = new Analysis.User(2, "2");
        Analysis.User thirdUser = new Analysis.User(3, "3");
        Analysis.User fourthUser = new Analysis.User(4, "4");
        List<Analysis.User> listBefore = Arrays.asList(firstUser, secondUser, thirdUser, fourthUser);
        Analysis.User addedUser = new Analysis.User(5, "5");
        Analysis.User changedUser = new Analysis.User(3, "6");
        List<Analysis.User> listAfter = Arrays.asList(addedUser, secondUser, changedUser);

        Analysis analysis = new Analysis();
        Analysis.Info info = analysis.diff(listBefore, listAfter);

        assertThat(info.added, is(1));
        assertThat(info.deleted, is(2));
        assertThat(info.changed, is(1));
    }
}

