package com.amazonaws.devtx.webcrawler.infrastructure.webcrawler;

import com.amazonaws.devtx.webcrawler.adapters.webcrawler.WebCrawlerPort;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;

public class WebCrawlerImpl implements WebCrawlerPort {

    @Override
    public void crawl(String url, Set<String> crawledLinks) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");

            System.out.println("Crawling " + url);
            System.out.println("Found " + links.size() + " links");
            String linkUrl = links.get(0).attr("abs:href");
            System.out.println("First link: " + linkUrl);
            crawledLinks.add(linkUrl);

//            for (Element link : links) {
//                String linkUrl = link.attr("abs:href");
//                if (!crawledLinks.contains(linkUrl)) {
//                    crawledLinks.add(linkUrl);
//                    crawl(linkUrl, crawledLinks);
//                }
//            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
