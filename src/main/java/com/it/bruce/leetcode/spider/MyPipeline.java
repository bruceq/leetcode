package com.it.bruce.leetcode.spider;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class MyPipeline implements Pipeline {
    private String output;

    public MyPipeline(String output) {
        this.output = output;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));) {
                String bom = new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
                out.write(bom + entry.getValue());
                out.newLine();
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}