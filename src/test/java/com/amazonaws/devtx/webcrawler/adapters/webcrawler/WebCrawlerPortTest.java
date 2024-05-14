package com.amazonaws.devtx.webcrawler.adapters.webcrawler;

import com.amazonaws.devtx.webcrawler.infrastructure.webcrawler.WebCrawlerImpl;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WebCrawlerPortTest {

    String url ="https://zh.wikipedia.org/wiki/%E7%B6%B2%E8%B7%AF%E7%88%AC%E8%9F%B2";

    @Test
    void testCrawlValidUrl() {
        WebCrawlerPort webCrawler = new WebCrawlerImpl();
        Set<String> crawledLinks = new HashSet<>();
        webCrawler.crawl(url, crawledLinks);
        assertFalse(crawledLinks.isEmpty());
    }

    @Test
    void testCrawlDuplicateUrl() {
        WebCrawlerPort webCrawler = new WebCrawlerImpl();
        Set<String> crawledLinks = new HashSet<>();
        crawledLinks.add(url);

        webCrawler.crawl(url, crawledLinks);

        assertEquals(1, crawledLinks.size());
    }

    @Test
    void testCrawlInvalidUrl() {
        WebCrawlerPort webCrawler = new WebCrawlerImpl();
        Set<String> crawledLinks = new HashSet<>();
        webCrawler.crawl(url, crawledLinks);
        assertTrue(crawledLinks.isEmpty());
    }
}
