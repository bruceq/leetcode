package com.it.bruce.leetcode.李小龙;

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] chars = s.nextLine().toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int num = 0;
        for (char ch : chars) {
            if (null == map.get(ch)) {
                num = 0;
            } else {
                num = map.get(ch);
            }
            map.put(ch, num + 1);
        }
        int allSort = SortOne(chars.length);
        for (char key : map.keySet()) {
            allSort = allSort / SortOne(map.get(key));
        }
        System.out.println(allSort);
    }

    static int SortOne(int charsnum) {
        if (charsnum == 1) {
            return 1;
        }
        return charsnum * SortOne(charsnum - 1);
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String[] strs = scanner.nextLine().split("");
//            List<String> list = new ArrayList<>();
//            StringBuilder sb = new StringBuilder();
//            backtrack(list, sb, strs, 0);
//            System.out.println();
//        }
//    }
//
//    private static void backtrack(List<String> list, StringBuilder sb, String[] strs, int start) {
//        if (sb.length() == strs.length && !list.contains(sb.toString())) {
//            list.add(sb.toString());
//            return;
//        }
//        for(int i=start;i<strs.length;i++){
//            sb.append(strs[start]);
//            backtrack(list, sb, strs, start + 1);
//            sb.substring(0, sb.length() - 1);
//        }
//    }

}
