package com.amazonaws.devtx.webcrawler.adapters.webcrawler;

import java.util.Set;

public interface WebCrawlerPort {
    void crawl(String url, Set<String> crawledLinks);
}
