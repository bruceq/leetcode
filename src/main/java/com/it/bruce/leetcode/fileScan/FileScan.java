package com.it.bruce.leetcode.fileScan;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileScan {
    private static final int SORT_BY_SIZE = 1;
    private static final int SORT_BY_TIME = 2;

    public static void main(String[] args) {
        // 读取文件
        File file = FileUtils.getFile("D:\\迅雷下载");
        // 遍历文件下目录和文件
        Map<Long, String> fileMap = buildSortMap();
        // 搜索关键字
        String[] filter = {"txt", "exe", "csv"};
        // 把遍历后的结果进行存储
        scanFiles(file, fileMap, SORT_BY_SIZE, filter);
        // 对于存储结果进行输出
        outputCSV("D:\\111.csv", fileMap);
    }

    /**
     * 构建排序后的map
     *
     * @return
     */
    private static Map<Long, String> buildSortMap() {
        return new TreeMap<Long, String>(new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1); //用正负表示大小值
            }
        });
    }

    /**
     * 输出CSV
     *
     * @param outputPath
     * @param fileMap
     */
    private static void outputCSV(String outputPath, Map<Long, String> fileMap) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8"));) {
            String bom = new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
            String strings = bom + "文件路径,文件大小,修改日期";
            out.write(strings);
            out.newLine();
            for (Map.Entry<Long, String> entry : fileMap.entrySet()) {
                out.write(bom + entry.getValue());
                out.newLine();
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描文件
     *
     * @param file
     * @param map
     * @return
     */
    private static Map<Long, String> scanFiles(File file, Map<Long, String> map, int sortType, String[] filter) {
        if (!file.exists()) {
            return new HashMap<Long, String>();
        }
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isDirectory()) {
                scanFiles(f, map, sortType, filter);
            } else {
                try {
                    if (sortType == SORT_BY_SIZE) {
                        saveDataBySize(map, f, filter);
                    } else if (sortType == SORT_BY_TIME) {
                        saveDataByTime(map, f, filter);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /**
     * 根据文件大小排序，存储
     *
     * @param map
     * @param f
     * @throws IOException
     */
    private static void saveDataBySize(Map<Long, String> map, File f, String[] filter) throws IOException {
        StringJoiner sj = new StringJoiner(",");
        buildFileData(map, f, filter, sj);
    }

    /**
     * 根据文件修改时间排序，存储
     *
     * @param map
     * @param f
     * @throws IOException
     */
    private static void saveDataByTime(Map<Long, String> map, File f, String[] filter) throws IOException {
        StringJoiner sj = new StringJoiner(",");
        buildFileData(map, f, filter, sj);
    }

    /**
     * 封装map信息
     *
     * @param map
     * @param f
     * @param filter
     * @param sj
     * @throws IOException
     */
    private static void buildFileData(Map<Long, String> map, File f, String[] filter, StringJoiner sj) throws IOException {
        if (filter.length == 0) {
            sj.add(f.getCanonicalPath());
            sj.add(transformSize(f.length()));
            sj.add(getTime(f));
            map.put(f.length(), sj.toString());
        } else {
            for (String fil : filter) {
                if (f.getCanonicalPath().toLowerCase(Locale.US).contains(fil)) {
                    sj.add(f.getCanonicalPath());
                    sj.add(transformSize(f.length()));
                    sj.add(getTime(f));
                    map.put(f.length(), sj.toString());
                }
            }
        }
    }

    /**
     * 获取
     *
     * @param file
     * @return
     */
    private static Long getFileTime(File file) {
        return file.lastModified();
    }

    /**
     * 获取时间
     *
     * @param file
     * @return
     */
    private static String getTime(File file) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cal.setTimeInMillis(getFileTime(file));
        return formatter.format(cal.getTime());
    }

    /**
     * 文件大小单位转换
     *
     * @param size
     * @return
     */
    private static String transformSize(Long size) {
        Long sizeGb = size / (1024 * 1024 * 1024);
        Long sizeMb = size / (1024 * 1024);
        Long sizeKb = size / (1024);
        if (sizeGb > 0) {
            return sizeGb + "G";
        } else if (sizeMb > 0) {
            return sizeMb + "M";
        } else if (sizeKb > 0) {
            return sizeKb + "K";
        } else {
            return size + "B";
        }
    }
}
