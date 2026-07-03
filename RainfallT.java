
package SsewankamboElijah.rainfall;

import java.util.Random;

public class RainfallT {

// Save this file as RainfallTracker.java
    public static void main(String[] args) {
        double[] dailyRainfall = new double[30];
        Random rand = new Random();

        // 1. Generate 30 random daily rainfall readings between 0 and 60 mm
        for (int i = 0; i < dailyRainfall.length; i++) {
            // rand.nextDouble() produces a value from 0.0 to 1.0, scaled here up to 60.0
            dailyRainfall[i] = rand.nextDouble() * 60.0;
        }

        double totalRainfall = 0.0;
        int wetDaysCount = 0;

        // Process total rainfall and count wet days
        for (int i = 0; i < dailyRainfall.length; i++) {
            double currentReading = dailyRainfall[i];
            totalRainfall += currentReading;

            // Counts the day as a "wet day" if rainfall exceeds 30 mm
            if (currentReading > 30.0) {
                wetDaysCount++;
            }
        }

        // Calculate the monthly average
        double averageRainfall = totalRainfall / dailyRainfall.length;

        // 2. Display computed totals and metrics
        System.out.println("=== ORTIS METEOROLOGICAL INSIGHTS ===");
        System.out.printf("Total Monthly Rainfall   : %.2f mm\n", totalRainfall);
        System.out.printf("Average Daily Rainfall   : %.2f mm\n", averageRainfall);
        System.out.println("Number of Wet Days (>30mm): " + wetDaysCount);
        System.out.println("------------------------------------");

        // 3. Classify the month using an if-else-if structure
        String classification;
        if (totalRainfall <= 300.0) {
            classification = "Dry (Risk of dry spells)";
        } else if (totalRainfall < 600.0) {
            classification = "Normal (Optimal agricultural conditions)";
        } else {
            classification = "Flood-risk (High accumulation warning)";
        }

        System.out.println("Seasonal Risk Assessment: " + classification);
        System.out.println("====================================");
    }
}
