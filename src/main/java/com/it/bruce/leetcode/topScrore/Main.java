package com.it.bruce.leetcode.topScrore;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static List<String[]> dataList = new CopyOnWriteArrayList<>();

    // 大小为10G的文件（记录学生成绩）中，找到成绩为top100的学生名字和成绩
    // 名字,成绩(整数)
    public static void main(String[] args) {
        // 拆分文件
        splitFile("D:\\111.csv");
        // 创建线程读取文件
        // 每个文件取top100
        createReadFileThreadPool("D:\\split");
        // 所有top汇聚，取最终的top100
        outputResult();
    }

    /**
     * 汇总每个小文件的top100，并输出最终结果
     */
    private static void outputResult() {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String[] data : dataList) {
            if (map.containsKey(Integer.parseInt(data[1]))) {
                map.get(Integer.parseInt(data[1])).add(data[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(data[0]);
                map.put(Integer.parseInt(data[1]), list);
            }
        }
        List<Integer> scoreList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            scoreList.add(entry.getKey());
        }
        Integer[] scoreArr = scoreList.toArray(new Integer[scoreList.size()]);
        Arrays.sort(scoreArr);
        int index = 1;
        System.out.println("TOP 100的同学和成绩如下：");
        for (int i = scoreArr.length - 1; i > 0; i--) {
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                if (index <= 100) {
                    System.out.println("第" + index + "名的同学是：" + entry.getKey() + "，成绩为：" + entry.getValue());
                }
            }
        }
    }


    /**
     * 使用线程池，多线程读取拆分后的CSV内容
     *
     * @param path
     */
    private static void createReadFileThreadPool(String path) {
        File parent = new File(path);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        if (parent.exists()) {
            if (parent.isDirectory()) {
                File[] files = parent.listFiles();
                for (File file : files) {
                    executorService.execute(new MyRunnale(file.getAbsolutePath()));
                }
            }
        }
        executorService.shutdown();
    }

    /**
     * 把10G的CSV文件拆分成小的CSV文件
     *
     * @param filePath
     */
    private static void splitFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            int index = 1;
            int name = 1;
            while ((line = file.readLine()) != null) {
                if (index % 10000 == 0) {
                    writeCSV("D:\\split\\" + name, list);
                    name++;
                    index = 1;
                    list.clear();
                }
                list.add(line);
                index++;
            }
            if (index > 1) {
                writeCSV("D:\\split\\" + name, list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CSV文件边读边写
     *
     * @param path
     */
    private static void readCSV(String path) {
        try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            String line;
            List<String[]> list = new ArrayList<>();
            while ((line = file.readLine()) != null) {
                List<Integer> scoreList = new ArrayList<>();
                if (list.size() <= 100) {
                    list.add(line.split(","));
                    scoreList.add(Integer.parseInt(line.split(",")[1]));
                } else {
                    Arrays.sort(list.toArray());
                    if (Integer.parseInt(line.split(",")[1]) > scoreList.get(0)) {
                        scoreList.remove(0);
                        scoreList.add(Integer.parseInt(line.split(",")[1]));
                        list.add(line.split(","));
                    }
                }
            }
            synchronized (dataList) {
                dataList.addAll(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写CSV文件
     *
     * @param path
     * @param data
     */
    private static void writeCSV(String path, List<String> data) {
        try {
            File csv = new File(path); // CSV数据文件
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            // 添加新的数据行
            for (String d : data) {
                bw.write(d);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter在关闭对象捕捉异常
            e.printStackTrace();
        }
    }

    /**
     * 创建线程执行分批读取CSV操作
     */
    static class MyRunnale implements Runnable {
        String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public MyRunnale(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            readCSV(path);
        }
    }
}
