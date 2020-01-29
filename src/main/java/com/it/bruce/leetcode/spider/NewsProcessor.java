package com.it.bruce.leetcode.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class NewsProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.putField("title", page.getHtml().xpath("//ul[@class='home article-list orderby-last-publish active']/li/div[@class='list-item']/h4/a/text()").all());
        page.putField("news", page.getHtml().xpath("//div[@class='item-info']/div[@class='item-content']/text()").all());
    }

    @Override
    public Site getSite() {
        site.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        site.addHeader("cookie", "Hm_lvt_8ab18ec6e3ee89210917ef2c8572b30e=1580137352; UM_distinctid=16fe78689ff5ab-07c53d1ded9c97-6701b35-1fa400-16fe7868a003e7; PHPSESSID=0701bccea6408ba71a5666aed935e7bf; CNZZDATA1278550924=1611599414-1580132349-https%253A%252F%252Fwww.guancha.cn%252F%7C1580132349; Hm_lpvt_8ab18ec6e3ee89210917ef2c8572b30e=1580137409");
        site.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new NewsProcessor()).addPipeline(new MyPipeline()).addUrl("https://user.guancha.cn/topic/attention-topic?follow-topic-id=116120&s=fwrmhtyc").run();
    }
}
