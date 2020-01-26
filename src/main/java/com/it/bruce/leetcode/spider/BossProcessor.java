package com.it.bruce.leetcode.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class BossProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.putField("job", page.getHtml().xpath("//div[@class='job-menu'").xpath("//a/text()").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new BossProcessor()).addPipeline(new MyPipeline("D:\\job.txt")).addUrl("https://www.zhipin.com/xian/?sid=sem_pz_bdpc_dasou_title").thread(5).run();
    }
}