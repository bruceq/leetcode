package com.it.bruce.leetcode._1282.用户分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] n = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(main.groupThePeople(n));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.get(groupSizes[i]) == null) {
                map.put(groupSizes[i], new ArrayList<>());
                map.get(groupSizes[i]).add(i);
            } else {
                map.get(groupSizes[i]).add(i);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == entry.getKey()) {
                list.add(entry.getValue());
            } else {
                List<Integer> tem = new ArrayList<>();
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if ((i + 1) % entry.getKey() == 0) {
                        tem.add(entry.getValue().get(i));
                        list.add(new ArrayList<>(tem));
                        tem.clear();
                    } else {
                        tem.add(entry.getValue().get(i));
                    }
                }
            }
        }
        return list;
    }
}
