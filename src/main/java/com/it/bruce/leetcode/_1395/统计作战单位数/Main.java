package com.it.bruce.leetcode._1395.统计作战单位数;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int[] rating = {89, 61, 13, 36, 37, 39, 97, 76, 84, 18, 12, 24, 71, 33, 44, 85, 70, 82, 15, 74, 35, 66, 59, 8, 3, 96, 30, 16, 41, 7, 10, 68, 92, 83, 95, 77, 9, 14, 81, 88, 38};
        int[] rating = {51532, 33628, 42845, 67824, 36686, 51896, 1348, 85375, 95408, 58441, 22234, 38156, 99472, 97541, 72507, 80101, 50478, 83740, 54114, 90518, 73962, 41212, 5316, 1988, 67822, 66009, 69813, 44420, 93231, 92908, 37519, 31985, 16272, 4099, 91544, 8243, 87619, 50214, 23110, 22823, 49786, 71578, 11931, 31150, 73690, 66983, 49696, 95679, 71562, 61008, 47648, 29109, 54585, 4732, 73860, 19500, 6076, 33053, 6804, 25236, 39688, 29118, 55932, 61869, 2833, 96855, 89474, 52558, 79619, 89103, 812, 26201, 56898, 43703, 74801, 26802, 5672, 60692, 93439, 14446, 75989, 63032, 74289, 69253, 89300, 28963, 43925, 66725, 77417, 97041, 60418, 18309, 50913, 30875, 39031, 72365, 3730, 72704, 52271, 32778, 18741, 59013, 59381, 77491, 68328, 39726, 20800, 1729, 65725, 18317, 24177, 87883, 69252, 91196, 8247, 49637, 28911, 96661, 10364, 22888, 67516, 47022, 41941, 20986, 53206, 83758, 67656, 71580, 76527, 78524, 39103, 61855, 18302, 85092, 6938, 6805, 17928, 76614, 56714, 39116, 89546, 30390, 98959, 35827, 25952, 2635, 32445, 20023, 38413, 90779, 82102, 20228, 87563, 47765, 6744, 39562, 22608, 50136, 92155, 50918, 33926, 42433, 88825, 63383, 61432, 36155, 64486, 17554, 97883, 33806, 21367};
//        int[] rating = {2, 5, 3, 4, 1};
        System.out.println(main.numTeams(rating));
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int[] left = count(rating, 0, i, rating[i]);
            int[] right = count(rating, i, n, rating[i]);
            result += left[0] * right[1] + left[1] * right[0];
        }
        return result;
    }

    private int[] count(int[] rating, int from, int to, int key) {
        int[] results = new int[2];
        for (int i = from; i < to; ++i) {
            if (rating[i] < key) {
                ++results[0];
            } else if (rating[i] > key) {
                ++results[1];
            }
        }
        return results;
    }
//    public int numTeams(int[] rating) {
//        if (rating.length < 3) {
//            return 0;
//        }
//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(rating, 0, list, new ArrayList<>());
//        return list.size();
//    }
//
//    private void backtrack(int[] rating, int start, List<List<Integer>> list, List<Integer> tempList) {
//        if (check(tempList, rating)) {
//            list.add(new ArrayList<>(tempList));
//        }
//        for (int i = start; i < rating.length; i++) {
//            if (tempList.size() <= 3) {
//                tempList.add(i);
//                backtrack(rating, i + 1, list, tempList);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }
//
//    private boolean check(List<Integer> tempList, int[] rating) {
//        if (tempList.size() != 3) {
//            return false;
//        }
//        int rank[] = new int[3];
//        for (int i = 0; i < 3; i++) {
//            rank[i] = rating[tempList.get(i)];
//        }
//        if ((rank[0] < rank[1] && rank[1] < rank[2]) || (rank[0] > rank[1] && rank[1] > rank[2])) {
//            return true;
//        }
//        return false;
//    }
}
