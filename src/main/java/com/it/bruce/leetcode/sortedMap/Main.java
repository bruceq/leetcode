package com.it.bruce.leetcode.sortedMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer, User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 首先拿到map键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        // 将set集合转为List集合，为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
        // 使用Collections集合工具类对list进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                // 按照规则根据User的age的倒叙进行排序
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        // 创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        // 将List中数据存储在LinkedHashMap中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        // 返回结果
        return linkedHashMap;
    }

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
