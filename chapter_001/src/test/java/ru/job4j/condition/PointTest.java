package ru.job4j.condition;
import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenDistancePointAThenB() {
        Point a = new Point(0,1);
        Point b = new Point(2,5);
        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(4.47, 0.1));
    }
}