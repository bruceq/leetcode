package com.it.bruce.leetcode.Inteview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            Map<Integer, Integer> map = new HashMap<>();
            boolean flag = false;
            for (int i = 0; i < str.length; i++) {
                if (map.get(Integer.parseInt(str[i])) == null) {
                    map.put(Integer.parseInt(str[i]), 1);
                } else {
                    map.put(Integer.parseInt(str[i]), map.get(Integer.parseInt(str[i])) + 1);
                    Integer m = map.get(Integer.parseInt(str[i]));
                    if (m > (n / 2)) {
                        System.out.println(Integer.parseInt(str[i]));
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }


    }
}
