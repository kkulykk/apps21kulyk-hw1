package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }

    public double average() {
        double sum = 0;
        int length = temperatureSeries.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        } else {
        for (int i = 0; i < length; i++) {
            sum += i;
        }
        return sum / length; }
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        return 0;
    }

    public double max() {
        return 0;
    }

    public double findTempClosestToZero() {
        int length = temperatureSeries.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        double closest = 0;
        double diff = Double.POSITIVE_INFINITY;
        for (double current: temperatureSeries) {
            if (Math.abs(current - closest) < diff) {
                diff = current - closest;
                closest = current;
            } else if (Math.abs(current - closest) == diff && current > 0) {
                closest = current;
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
