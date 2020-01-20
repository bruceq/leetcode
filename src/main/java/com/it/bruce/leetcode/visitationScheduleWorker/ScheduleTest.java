package com.it.bruce.leetcode.visitationScheduleWorker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTest {
    private int i = 0;

    @Scheduled(fixedRate = 60 * 2 * 1000)
    void schedule() {
        String[] url = {
                "https://blog.csdn.net/qixinbruce/article/details/103706963",
                "https://blog.csdn.net/qixinbruce/article/details/103838496",
                "https://blog.csdn.net/qixinbruce/article/details/103850097",
                "https://blog.csdn.net/qixinbruce/article/details/103850092",
                "https://blog.csdn.net/qixinbruce/article/details/103883685",
                "https://blog.csdn.net/qixinbruce/article/details/103899611",
                "https://blog.csdn.net/qixinbruce/article/details/103917398",
                "https://blog.csdn.net/qixinbruce/article/details/103947579",
                "https://blog.csdn.net/qixinbruce/article/details/103944402",
                "https://blog.csdn.net/qixinbruce/article/details/104010678",
                "https://blog.csdn.net/qixinbruce/article/details/103624754",
                "https://blog.csdn.net/qixinbruce/article/details/104047344"
        };
        for (String r : url) {
            if (i == 6000) {
                break;
            }
            HttpUtils.doGet(r);
            i++;
            System.out.println("博客：" + r + " 已刷新" + i + "次");
        }
    }
}
