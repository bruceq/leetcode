package com.it.bruce.leetcode._57.InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        int[] newIntervals = {2, 5};
        int[][] merge = main.insert(intervals, newIntervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println("[" + merge[i][0] + "," + merge[i][1] + "]");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] finalIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            finalIntervals[i] = intervals[i];
        }
        finalIntervals[intervals.length] = newInterval;
        // Sort by ascending starting point
        Arrays.sort(finalIntervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] temInterval = finalIntervals[0];
        result.add(temInterval);
        for (int[] interval : finalIntervals) {
            if (interval[0] <= temInterval[1]) // Overlapping intervals, move the end if needed
                temInterval[1] = Math.max(temInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                temInterval = interval;
                result.add(temInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
