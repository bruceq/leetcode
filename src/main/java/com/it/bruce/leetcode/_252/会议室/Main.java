package com.it.bruce.leetcode._252.会议室;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{7, 10}, {2, 4}, {2, 5}, {2, 3}};
//        int[][] intervals = {{7, 10}, {8, 10}};
        Main main = new Main();
        System.out.println(main.canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        List<int[]> collect = Arrays.asList(intervals).stream().sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] == 0) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        }).collect(Collectors.toList());
        collect.forEach(s -> System.out.println("{" + s[0] + "," + s[1] + "}"));
        if (intervals.length < 1) {
            return true;
        } else {
            for (int i = 1; i < intervals.length; i++) {
                if (collect.get(i)[0] < collect.get(i - 1)[1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
