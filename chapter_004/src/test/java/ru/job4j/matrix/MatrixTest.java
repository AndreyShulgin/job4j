package ru.job4j.matrix;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MatrixTest {

    @Test
    public void whenMatrixToListThenList() {
        Matrix matrix = new Matrix();
        Integer[][] array = {{1, 2}, {3, 4}};
        List<Integer> result = matrix.toList(array);
        assertThat(result.get(1), is(2));
    }
}
