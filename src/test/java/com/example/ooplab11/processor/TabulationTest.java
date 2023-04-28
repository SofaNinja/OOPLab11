package com.example.ooplab11.processor;

import com.example.ooplab11.data.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TabulationTest {
    Processor processor = new Processor();
    double start = 3.0;
    double finish = 4.0;
    double step = 0.2;
    List<Point> testPoints = new ArrayList<>(Arrays.asList(
            new Point(3.0, 0.98008),
            new Point(3.2, 0.99659),
            new Point(3.4, 0.93469),
            new Point(3.6, -0.24617),
            new Point(3.8, -0.35474),
            new Point(4.0, -0.45564)
    ));
    public static double eps = 1e-5;
    @Test
    void checkPointsTest() {
        for (int i = 0; i < testPoints.size(); i++) {
            assertEquals(testPoints.get(i).y(), processor.tabulating(start,finish,step).get(i).y(), eps);
        }
    }
}