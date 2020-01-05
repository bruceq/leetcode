package com.it.bruce.leetcode.topScrore;

import java.util.*;

public class Test {
    // 大小为10G的文件（ ）中，找到成绩为top100的学生名字和成绩
    // 名字,成绩(整数)
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 初始化学生成绩信息
        init(list);
        // 使用hashmap把成绩和学生信息存起来<成绩，学生>
        Map<Integer, String> map = new HashMap<>();
        List<Integer> scoreList = new ArrayList<>();
        for (String l : list) {
            String[] student = l.split(",");
            String name = student[0];
            Integer score = Integer.parseInt(student[1]);
            // 如果map中数据个数大于100，则判断学生分数是否在top100之内
            if (map.size() > 4) {
                if (score > scoreList.get(0)) {
                    map.remove(scoreList.get(0));
                    scoreList.remove(0);
                    scoreList.add(score);
                    Arrays.sort(scoreList.toArray());
                    map.put(score, name);
                }
            } else {
                map.put(score, name);
                scoreList.add(score);
                Arrays.sort(scoreList.toArray());
            }
        }
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            System.out.println(m.getValue() + "," + m.getKey());
        }
    }

    private static void init(List<String> list) {
        list.add("qixin,10");
        list.add("qixin1,20");
        list.add("qixin2,30");
        list.add("qixin3,40");
        list.add("qixin4,50");
        list.add("qixin5,60");
        list.add("qixin6,70");
        list.add("qixin7,80");
        list.add("qixin8,90");
    }
}
