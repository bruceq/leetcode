package com.it.bruce.leetcode.designModel.observe;

public interface Observer {
    public void add(Employee employee);

    public void del(Employee employee);

    public void notifyEmployee();

    public void operation();
}
