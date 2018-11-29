package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                .append("   0").append(System.lineSeparator())
                .append("  000").append(System.lineSeparator())
                .append(" 00000").append(System.lineSeparator())
                .append("0000000")
                .toString()));
    }
}