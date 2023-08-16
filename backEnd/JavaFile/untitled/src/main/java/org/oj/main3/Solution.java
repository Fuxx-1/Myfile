package org.oj.main3;
public class Solution {
    public static int findStartStation(int[] charge, int[] cost) {
        int totalCharge = 0;
        int totalCost = 0;
        for (int c : charge) totalCharge += c;
        for (int c : cost) totalCost += c;
        if (totalCharge < totalCost) return -1;
        int numStations = charge.length;
        int currentCharge = 0;
        int startStation = 0;
        for (int i = 0; i < numStations; i++) {
            currentCharge += charge[i] - cost[i];
            if (currentCharge < 0) {
                currentCharge = 0;
                startStation = i + 1;
            }
        }
        return startStation;
    }
    public static void main(String[] args) {
        int[] charge = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int startStation = findStartStation(charge, cost);
        System.out.println(startStation);  // Output: 3

        int[] charge2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        int startStation2 = findStartStation(charge2, cost2);
        System.out.println(startStation2);  // Output: -1
    }
}