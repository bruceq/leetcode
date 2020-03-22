package com.it.bruce.leetcode._71.SimplifyPath;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..") && !list.isEmpty()) {
                list.remove(list.size() - 1);
            } else {
                list.add(s);
            }
        }
        String result = "";
        if (list.isEmpty()) result = "/";
        for (String s : list) result += "/" + s;
        return result;
    }
}
