package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void whenTrackerSingleEnum() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker1, is(tracker2));
        assertThat(tracker2, is(tracker1));

    }

    @Test
    public void whenTrackerSingleLazy() {
        TrackerSingleLazy tracker1 = TrackerSingleLazy.getInstance();
        TrackerSingleLazy tracker2 = TrackerSingleLazy.getInstance();
        assertThat(tracker1, is(tracker2));
        assertThat(tracker2, is(tracker1));

    }

    @Test
    public void whenTrackerSingleEager() {
        TrackerSingleEager tracker1 = TrackerSingleEager.getInstance();
        TrackerSingleEager tracker2 = TrackerSingleEager.getInstance();
        assertThat(tracker1, is(tracker2));
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void whenTrackerSingleInnerClass() {
        TrackerSingleInnerClass tracker1 = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass tracker2 = TrackerSingleInnerClass.getInstance();
        assertThat(tracker1, is(tracker2));
        assertThat(tracker2, is(tracker1));
    }
}
