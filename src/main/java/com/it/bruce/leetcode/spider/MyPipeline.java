package com.it.bruce.leetcode.spider;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyPipeline implements Pipeline {
    private static AtomicInteger atomicInteger=new AtomicInteger(1);

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            list.addAll((Collection<? extends String>) entry.getValue());
        }
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\" + atomicInteger + ".txt"), "UTF-8"))) {
            atomicInteger.addAndGet(1);
            String bom = new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
            out.write(bom + list);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}