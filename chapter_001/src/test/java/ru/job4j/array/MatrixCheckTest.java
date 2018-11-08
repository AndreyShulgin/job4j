package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDiagonalFalseOrTrueThenTrue2() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] table = {
                {true, false, false, true},
                {false, true, true, false},
                {false, true, true, false},
                {true, false, false, true}
        };
        boolean result = matrix.mono(table);
        assertThat(result, is(true));
    }

    @Test
    public void whenDiagonalFalseOrTrueThenTrue() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] table = {
                {true, false, false, true},
                {false, true, true, false},
                {true, true, true, false},
                {false, false, false, true}
        };
        boolean result = matrix.mono(table);
        assertThat(result, is(false));
    }
}