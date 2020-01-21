package com.it.bruce.leetcode.visitationScheduleWorker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTest {
    private int i = 0;

    @Scheduled(fixedRate = 60 * 1 * 1500)
    void schedule() {
        String[] url = {
                "https://blog.csdn.net/qixinbruce/article/details/104056939",
                "https://blog.csdn.net/qixinbruce/article/details/104047344",
                "https://blog.csdn.net/qixinbruce/article/details/104010678"
        };
        for (String r : url) {
            if (i == 3000) {
                break;
            }
            HttpUtils.doGet(r);
            i++;
            System.out.println("博客：" + r + " 已刷新" + i + "次");
        }
    }
}
