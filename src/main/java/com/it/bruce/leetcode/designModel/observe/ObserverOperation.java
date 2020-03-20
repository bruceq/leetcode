package com.it.bruce.leetcode.designModel.observe;

import java.util.ArrayList;
import java.util.List;

public class ObserverOperation implements Observer {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void del(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void notifyEmployee() {
        for (Employee employee : employees) {
            employee.observe();
        }
    }

    @Override
    public void operation() {
        System.out.println("Boss is coming!");
        notifyEmployee();
    }
}
