package ua.edu.ucu.tempseries;

import lombok.NonNull;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int length = 0;
    private final int minValue = -273;
    private final int maxValue = 10000;

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(@NonNull double[] temperatureSeries) {
        for (double temperatures : temperatureSeries) {
            if (temperatures < minValue) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        length = temperatureSeries.length;
    }

    public double average() {
        double sum = 0;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        for (double temperature : temperatureSeries) {
            sum += temperature;
        }
        return sum / length;
    }

    public double deviation() {
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        double sd = 0;
        for (int i = 0; i < length; i++) {
            sd += sd + ((temperatureSeries[i] - average())
                    * (temperatureSeries[i] - average()));
        }
        return Math.sqrt(sd / length);
    }

    public double min() {
        return findTempClosestToValue(minValue);
    }

    public double max() {

        return findTempClosestToValue(maxValue);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        double distance = Math.abs(temperatureSeries[0] - tempValue);
        int closest = 0;
        for (int i = 1; i < length; i++) {
            double current = Math.abs(temperatureSeries[i] - tempValue);
            if (current < distance) {
                closest = i;
                distance = current;
            } else if (current == distance && temperatureSeries[i] > 0) {
                closest = i;
            }
        }
        return temperatureSeries[closest];
    }

    public double[] findTempsLessThen(double tempValue) {
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] < tempValue) {
                counter++;
            }
        }
        double[] result = new double[counter];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] < tempValue) {
                result[index] = temperatureSeries[i];
                index++;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] > tempValue) {
                counter++;
            }
        }
        double[] result = new double[counter];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] > tempValue) {
                result[index] = temperatureSeries[i];
                index++;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < minValue) {
                throw new InputMismatchException();
            }
        }
        int capacity = length;
        int expectedSize = length + temps.length;
        int result = 0;
        while (capacity < expectedSize) {
            capacity *= 2;
            temperatureSeries = Arrays.copyOf(temperatureSeries, capacity);
        }
        int counter = 0;
        for (int i = length; i < expectedSize; i++) {
            temperatureSeries[i] = temps[counter];
            counter += 1;
        }
        for (double temperatures: temperatureSeries) {
            result += temperatures;
        }
        return result;
    }

}
