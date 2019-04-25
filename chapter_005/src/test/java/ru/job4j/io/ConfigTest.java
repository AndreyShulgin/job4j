package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenAddKeysAndValuesFromLineThanFalse() {
        Config config = new Config("./../app.properties");
        config.load();
        assertNull(config.value("key not found"));
    }

    @Test
    public void whenAddKeysAndValuesFromLineThanTrue() {
        Config config = new Config("./../app.properties");
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }
}