package ru.job4j.readconfig;

import org.junit.Test;
import ru.job4j.readconfig.Config;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "../chapter_002_input-output/src/main/java/readConfig/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }
}
