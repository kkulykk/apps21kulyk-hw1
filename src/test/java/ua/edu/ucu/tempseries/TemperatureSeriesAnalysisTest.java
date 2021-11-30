package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double expResult = 6.928203230275509;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(2);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void findTempsLessThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double[] expResult = new double[] {-5.0, 1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void findTempsGreaterThen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        double[] expResult = new double[] {5.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void summaryStatistics() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0, 1.0, 5.0});
        TempSummaryStatistics tempSummaryStatistics = seriesAnalysis.summaryStatistics();
        assertEquals(1.0, tempSummaryStatistics.getAvgTemp(), 0.00001);
        assertEquals(6.928203230275509, tempSummaryStatistics.getDevTemp(), 0.00001);
        assertEquals(5.0, tempSummaryStatistics.getMaxTemp(), 0.00001);
        assertEquals(-5.0, tempSummaryStatistics.getMinTemp(), 0.00001);
    }

    @Test
    public void addTemps() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[] {3.0, -5.0});
        assertEquals(10, seriesAnalysis.addTemps(5.0, 7.0));
    }

}
