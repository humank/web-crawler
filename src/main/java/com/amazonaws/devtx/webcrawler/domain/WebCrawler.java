package com.amazonaws.devtx.webcrawler.domain;

import java.util.Set;

public interface WebCrawler {
    void crawl(String url, Set<String> crawledLinks);
}
