package com.example.ooplab11.processor;

import com.example.ooplab11.data.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Processor {
    private double start;
    private double finish;
    private double step;

    private double function(double x) {
        if (x > (3.4 + 1e-9)) {
            return (Math.sin(x) * Math.log10(x));
        } else {
            double cos = Math.cos(x);
            return (cos * cos);
        }
    }

    public List<Point> tabulating(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = (int) Math.round((finish - start) / step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = function(x);
            points.add(new Point(x, y));
        }
        return points;
    }

    public double countStep() {
        if (start == finish) return 0;
        return Math.round((finish - start) / step + 1);
    }

    public Point getMax(List<Point> points) { /// test 1 instead of 0 if not works with 0
        Point max = points.get(0);
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y() > max.y()) {
                max = points.get(i);
            }
        }
        return max;
    }

    public Point getMin(List<Point> points) {
        Point min = points.get(1);
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y() < min.y()) {
                min = points.get(i);
            }
        }
        return min;
    }

    public double getSum(List<Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum += points.get(i).y();
        }
        return sum;
    }

    public double getAverage(List<Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum += points.get(i).y();
        }
        return sum / points.size();
    }
}