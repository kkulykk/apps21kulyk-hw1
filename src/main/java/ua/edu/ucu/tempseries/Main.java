package ua.edu.ucu.tempseries;

public class Main {

    public static void find(double[] array) {
        int length = array.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        double closest = 0;
        double diff = Double.POSITIVE_INFINITY;
        for (double current: array) {
            if (Math.abs(current - closest) < diff) {
                diff = current - closest;
                closest = current;
            } else if (Math.abs(current - closest) == diff && current > 0) {
                closest = current;
            }
        }
        System.out.println(closest);
    }

    public static void main(String[] args) {
        double[] array = {1,2,3,4};
        find(new double[5]);
    }

}
