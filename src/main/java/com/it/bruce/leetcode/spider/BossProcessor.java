package com.it.bruce.leetcode.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class BossProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        String s = page.getHtml().xpath("//div[@class='page']/a[@class='next']").links().get();
        page.addTargetRequest(s);
//        page.addTargetRequest("https://www.zhipin.com/c101110100/y_3/?page=3&ka=page-3");
//        page.addTargetRequest("https://www.zhipin.com/c101110100/y_3/?page=4&ka=page-4");
//        page.addTargetRequest("https://www.zhipin.com/c101110100/y_3/?page=5&ka=page-5");
        page.putField("job", page.getHtml().xpath("//div[@class='job-list']/ul/li/div[@class='job-primary']/div[@class='info-primary']/div[@class='primary-wrapper']/a/div[@class='job-title']/span[@class='job-name']/text()").all());
        page.putField("addr", page.getHtml().xpath("//div[@class='job-list']/ul/li/div[@class='job-primary']/div[@class='info-primary']/div[@class='primary-wrapper']/a/div[@class='job-title']/span[@class='job-area-wrapper']/span/text()").all());
        page.putField("company", page.getHtml().xpath("//div[@class='job-list']/ul/li/div[@class='job-primary']/div[@class='info-primary']/div[@class='info-company']/div/h3/a/text()").all());
    }

    @Override
    public Site getSite() {
        site.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        site.addHeader("cookie", "lastCity=101110100; sid=sem; toUrl=/; JSESSIONID=\"\"; __c=1580131058; __g=sem; __l=l=https%3A%2F%2Fwww.baidu.com%2Fbaidu.php%3Fsc.K60000avpXkFvm720AMxYsMSjb1Rfm2VA2YNs-TC6Xcb2kqqHcm3EdkAZMZWYJF_p0sRMKx7P4htvKC02mfCEJOcCv5DCwPvU7XwJN2d3PeNgLDXMGrs_fBNd0r_htoCk_ChmkBnKR6nBaml7YS-ZmUEXsOoXzXBEnlUvG-pw3CVm1zrw4y336LyT7B1xO2deg3nLgC7Gzuglc_Q13LDAdT0VcRT.DR_NR2Ar5Od663rj6t8AGSPticnDpuCcYlxZMLWknwGYqxu68uTkxIW94UvTyj59tqvZut_r11sSXejE33I-XZ1LmIMzseOU9tOZjESyZdSVhHvde5OKeUrMkLqTI7hFWtJXj59tqvZxkse2t5M33IhOj_SZj4en5VS8Zut_qheo6BxfmsSXejE33I-XZ1tTr1x9vxjMsSxW9qx-9Ld3x5I9LOQj__lqJIZ0lp4WSWt54E94ULwk3x5kseOgjlqhZ1vmI-XZx_sSxW9vUn5VSZj4e_r1l3IOiGyAp7WGLuPOBC0.U1Yk0ZDqmhq1TqpkkoW7snB90ZKGm1Ys0Zfqmhq1TqpkkoW7snB90A-V5HcsP0KM5yqbXWD0Iybqmh7GuZR0TA-b5HcL0APGujYzPjf0UgfqnH0krNtknjDLg1DknjRsg1nvnjD0pvbqn0KzIjY4n1b0uy-b5HDYPjuxnWDsrjNxnH6dPH-xnWm1PHKxnWckPHb0mhbqnHRdg1Ddr7tznjwxnWDL0AdW5HDsnj7xnH6YP1T1njTdr7tknjFxn0KkTA-b5H00TyPGujYs0ZFMIA7M5H00mycqn7ts0ANzu1Ys0ZKs5Hcsn16knH0drj00UMus5H08nj0snj0snj00Ugws5H00uAwETjYs0ZFJ5H00uANv5gKW0AuY5H00TA6qn0KET1Ys0AFL5HDs0A4Y5H00TLCq0A71gv-bm1dsTzdWI0KGuAnqNDn0IZN15H6LnHnYn1nknjcsPWczn1TsrHf0ThNkIjYkPH6snHnsrHn1nj0z0ZPGujY4uj-hnHTLn10sn1FBnjIB0AP1UHd7fWbsP1DkfHf1PjbkPW7A0A7W5HD0TA3qn0KkUgfqn0KkUgnqn0KbugwxmLK95H00XMfqn0KVmdqhThqV5HKxn7tsg100uA78IyF-gLK_my4GuZnqn7tsg1fkrjnvPj7xn0Ksmgwxuhk9u1Ys0AwWpyfqn0K-IA-b5iYk0A71TAPW5H00IgKGUhPW5H00Tydh5H00uhPdIjYs0A-1mvsqn0KlTAkdT1Ys0A7buhk9u1Yk0Akhm1Ys0AwWmvfq0AFbpyfqnRuKfRDvwjfsPbRYnWf1wDu7P1u7Pj9AnHm4rH0LrjT0UvnqnfKBIjYz0AqY5HD0ULFsIjYzc10WnH0WnBnzPHf4nHR1PznkPj63c1DYrj68nj0snj0sc1DWnBns0Z7xIWYsQW6zg108njKxna3sn7tsQWDLg108nH7xna31nfK-XZfqn0KWThnqnHR4nWf%26word%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E7%2588%25AC%25E5%258F%2596%26ck%3D5170.12.98.339.150.373.143.158%26shh%3Dwww.baidu.com%26us%3D1.1129.4.0.0.0.0.0&r=https%3A%2F%2Fwww.baidu.com%2Fbaidu.php%3Fsc.K60000avpXkFvm720AMxYsMSjb1Rfm2VA2YNs-TC6Xcb2kqqHcm3EdkAZMZWYJF_p0sRMKx7P4htvKC02mfCEJOcCv5DCwPvU7XwJN2d3PeNgLDXMGrs_fBNd0r_htoCk_ChmkBnKR6nBaml7YS-ZmUEXsOoXzXBEnlUvG-pw3CVm1zrw4y336LyT7B1xO2deg3nLgC7Gzuglc_Q13LDAdT0VcRT.DR_NR2Ar5Od663rj6t8AGSPticnDpuCcYlxZMLWknwGYqxu68uTkxIW94UvTyj59tqvZut_r11sSXejE33I-XZ1LmIMzseOU9tOZjESyZdSVhHvde5OKeUrMkLqTI7hFWtJXj59tqvZxkse2t5M33IhOj_SZj4en5VS8Zut_qheo6BxfmsSXejE33I-XZ1tTr1x9vxjMsSxW9qx-9Ld3x5I9LOQj__lqJIZ0lp4WSWt54E94ULwk3x5kseOgjlqhZ1vmI-XZx_sSxW9vUn5VSZj4e_r1l3IOiGyAp7WGLuPOBC0.U1Yk0ZDqmhq1TqpkkoW7snB90ZKGm1Ys0Zfqmhq1TqpkkoW7snB90A-V5HcsP0KM5yqbXWD0Iybqmh7GuZR0TA-b5HcL0APGujYzPjf0UgfqnH0krNtknjDLg1DknjRsg1nvnjD0pvbqn0KzIjY4n1b0uy-b5HDYPjuxnWDsrjNxnH6dPH-xnWm1PHKxnWckPHb0mhbqnHRdg1Ddr7tznjwxnWDL0AdW5HDsnj7xnH6YP1T1njTdr7tknjFxn0KkTA-b5H00TyPGujYs0ZFMIA7M5H00mycqn7ts0ANzu1Ys0ZKs5Hcsn16knH0drj00UMus5H08nj0snj0snj00Ugws5H00uAwETjYs0ZFJ5H00uANv5gKW0AuY5H00TA6qn0KET1Ys0AFL5HDs0A4Y5H00TLCq0A71gv-bm1dsTzdWI0KGuAnqNDn0IZN15H6LnHnYn1nknjcsPWczn1TsrHf0ThNkIjYkPH6snHnsrHn1nj0z0ZPGujY4uj-hnHTLn10sn1FBnjIB0AP1UHd7fWbsP1DkfHf1PjbkPW7A0A7W5HD0TA3qn0KkUgfqn0KkUgnqn0KbugwxmLK95H00XMfqn0KVmdqhThqV5HKxn7tsg100uA78IyF-gLK_my4GuZnqn7tsg1fkrjnvPj7xn0Ksmgwxuhk9u1Ys0AwWpyfqn0K-IA-b5iYk0A71TAPW5H00IgKGUhPW5H00Tydh5H00uhPdIjYs0A-1mvsqn0KlTAkdT1Ys0A7buhk9u1Yk0Akhm1Ys0AwWmvfq0AFbpyfqnRuKfRDvwjfsPbRYnWf1wDu7P1u7Pj9AnHm4rH0LrjT0UvnqnfKBIjYz0AqY5HD0ULFsIjYzc10WnH0WnBnzPHf4nHR1PznkPj63c1DYrj68nj0snj0sc1DWnBns0Z7xIWYsQW6zg108njKxna3sn7tsQWDLg108nH7xna31nfK-XZfqn0KWThnqnHR4nWf%26word%3Dboss%25E7%259B%25B4%25E8%2581%2598%25E7%2588%25AC%25E5%258F%2596%26ck%3D5170.12.98.339.150.373.143.158%26shh%3Dwww.baidu.com%26us%3D1.1129.4.0.0.0.0.0&g=%2Fwww.zhipin.com%2Fuser%2Fsem7.html%3Fsid%3Dsem%26qudao%3Dbdpc_baidu-%25E5%258D%258E%25E5%2593%2581%25E5%258D%259A%25E7%259D%25BF02A18KA0679%26plan%3DNew-%25E5%2593%2581%25E7%2589%258C%25E8%25AF%258D-05%26unit%3D%25E5%2593%2581%25E7%2589%258C-%25E7%25BD%2591%25E5%259D%2580%26keyword%3DOCPC_boss%25E7%259B%25B4%25E8%2581%2598%25E7%2588%25AC%25E5%258F%2596%26bd_vid%3D10785949911620922175&friend_source=0&friend_source=0; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1579762718,1580055954,1580131058,1580140143; __a=97123898.1579762718.1580055954.1580131058.52.3.19.19; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1580141251; __zp_stoken__=19baa9dQhORlsDktwFn%2ByVz%2FaMhEb9%2FS%2FEboHrrez2gf%2FA6m%2BPxxKDrJQp2F5XnSLvpZJ6%2Byg5OYr12CrWhvb2%2F7PJ731XgHkF6kfDEXZaR0MdZbNV1L24EXNkqO2%2B3pXQ0%2B");
        site.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        site.setSleepTime(1000);
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new BossProcessor()).addPipeline(new MyPipeline()).addUrl("https://www.zhipin.com/c100010000/?page=9&ka=page-9").run();
    }
}