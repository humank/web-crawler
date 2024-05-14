package com.amazonaws.devtx.webcrawler.domain.services;

import com.amazonaws.devtx.webcrawler.adapters.webcrawler.WebCrawlerPort;
import com.amazonaws.devtx.webcrawler.domain.WebCrawlerService;
import com.amazonaws.devtx.webcrawler.domain.Website;
import com.amazonaws.devtx.webcrawler.domain.WebsiteRepository;
import com.amazonaws.devtx.webcrawler.domain.events.WebsiteEvent;
import org.springframework.context.ApplicationEventPublisher;


import java.util.HashSet;
import java.util.Set;

public class WebCrawlerServiceImpl implements WebCrawlerService {
    private final WebsiteRepository websiteRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final WebCrawlerPort webCrawler;

    public WebCrawlerServiceImpl(WebsiteRepository websiteRepository, ApplicationEventPublisher eventPublisher, WebCrawlerPort webCrawler) {
        this.websiteRepository = websiteRepository;
        this.eventPublisher = eventPublisher;
        this.webCrawler = webCrawler;
    }

    @Override
    public void crawlWebsite(Website website) {
        // Implement web crawling logic
        Set<String> crawledLinks = new HashSet<>();
        crawledLinks.add(website.getUrl());
        webCrawler.crawl(website.getUrl(), crawledLinks);
        checkInvariant(crawledLinks);

        // Save the crawled website
        websiteRepository.save(website);

        // Publish a domain event
        eventPublisher.publishEvent(new WebsiteEvent(website, WebsiteEvent.EventType.WEBSITE_CRAWLED));
    }

    // Invariant: crawledLinks should not contain duplicates
    private void checkInvariant(Set<String> crawledLinks) {
        // Implementation details
        if (crawledLinks.size() != new HashSet<>(crawledLinks).size()) {
            throw new IllegalStateException("Invariant violated: crawledLinks contains duplicates");
        }
    }
}
