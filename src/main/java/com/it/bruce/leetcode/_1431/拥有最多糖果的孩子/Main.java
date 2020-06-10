package com.it.bruce.leetcode._1431.拥有最多糖果的孩子;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int biggestNum = 0;
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy > biggestNum) {
                biggestNum = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= biggestNum) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
