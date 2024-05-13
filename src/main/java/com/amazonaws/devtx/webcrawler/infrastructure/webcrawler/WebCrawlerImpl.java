package com.amazonaws.devtx.webcrawler.infrastructure.webcrawler;

import com.amazonaws.devtx.webcrawler.domain.WebCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;

public class WebCrawlerImpl implements WebCrawler {

    @Override
    public void crawl(String url, Set<String> crawledLinks) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String linkUrl = link.attr("abs:href");
                if (!crawledLinks.contains(linkUrl)) {
                    crawledLinks.add(linkUrl);
                    crawl(linkUrl, crawledLinks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
