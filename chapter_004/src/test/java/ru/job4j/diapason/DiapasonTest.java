package ru.job4j.diapason;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;


public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, Math::exp);
        List<Double> expected = Arrays.asList(148.4131591025766, 403.4287934927351, 1096.6331584284585);
        Assert.assertThat(result, is(expected));
    }
}