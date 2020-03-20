package com.it.bruce.leetcode._101.SymmetricTree;

public class Test {
    static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        final Bussinesss bussinesss = new Bussinesss();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    threadLocal.set("fsda");
                    Object o = threadLocal.get();
                    bussinesss.subMethod();
                }
            }
        }).start();
        for (int i = 0; i < 3; i++) {
            bussinesss.mainMethod();
        }
    }

    static class Bussinesss {
        private boolean subFlag = true;

        public synchronized void mainMethod() {
            while (subFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": main thread running loop count --" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subFlag = true;
            notify();
        }

        public synchronized void subMethod() {
            while (!subFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": sub thread running loop count --" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subFlag = false;
            notify();
        }
    }
}
