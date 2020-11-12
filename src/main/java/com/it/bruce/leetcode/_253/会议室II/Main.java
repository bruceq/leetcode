package com.it.bruce.leetcode._253.会议室II;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int[][] intervals = {{5, 10}, {0, 30}, {15, 20}};
        int[][] intervals = {{7, 10}, {2, 4}};
        System.out.println(main.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> ints = Arrays.asList(intervals);
        Collections.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<List<int[]>> list = new ArrayList<>();
        for (int[] arr : ints) {
            if (list.size() == 0) {
                List<int[]> tempList = new ArrayList<>();
                tempList.add(arr);
                list.add(tempList);
            } else {
                boolean add = false;
                for (List<int[]> tem : list) {
                    if (tem.get(tem.size() - 1)[1] <= arr[0]) {
                        tem.add(arr);
                        add = true;
                        break;
                    }
                }
                if (!add) {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.add(arr);
                    list.add(tempList);
                }
            }
        }
        return list.size();
    }
}
