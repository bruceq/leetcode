package com.it.bruce.leetcode._101.SymmetricTree;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BTest {
    final static BlockingQueue<File> queue = new LinkedBlockingDeque<File>(100);
    final static ExecutorService exec = Executors.newFixedThreadPool(5);
    final static File root = new File("D:\\aaa");
    final static File exitFile = new File("");
    final static AtomicInteger rc = new AtomicInteger();
    final static AtomicInteger wc = new AtomicInteger();

    public static void main(String[] args) {
        Runnable read = new Runnable() {
            @Override
            public void run() {
                scanFile(root);
                scanFile(exitFile);
            }
        };
        exec.submit(read);
        for (int index = 0; index < 4; index++) {
            final int NO = index;
            Runnable write = new Runnable() {
                String threadNam = "write" + NO;

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            int index = wc.incrementAndGet();
                            File file = queue.take();
                            if (file == exitFile) {
                                queue.put(exitFile);
                                break;
                            }
                            System.out.println(threadNam + ":" + index + " " + file.getPath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            exec.submit(write);
        }
        exec.shutdown();
    }

    public static void scanFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || pathname.getPath().endsWith(".java");
                }
            });
            for (File one : files) {
                scanFile(one);
            }
        } else {
            try {
                int index = rc.incrementAndGet();
                System.out.println("Read0:" + index + " " + file.getPath());
                queue.put(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
