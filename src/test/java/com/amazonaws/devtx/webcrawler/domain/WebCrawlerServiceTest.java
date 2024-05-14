package com.amazonaws.devtx.webcrawler.domain;

import com.amazonaws.devtx.webcrawler.adapters.webcrawler.WebCrawlerPort;
import com.amazonaws.devtx.webcrawler.domain.services.WebCrawlerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

public class WebCrawlerServiceTest {
    @Mock
    private WebsiteRepository websiteRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private WebCrawlerPort webCrawler;

    private WebCrawlerService webCrawlerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        webCrawlerService = new WebCrawlerServiceImpl(websiteRepository, eventPublisher,webCrawler);
    }

    @Test
    public void testCrawlWebsite() {
        Website website = new Website("https://www.youtube.com/watch?v=pfAlmkzyaJQ", "test");

        webCrawlerService.crawlWebsite(website);

        verify(websiteRepository, times(1)).save(website);
        verify(eventPublisher, times(1)).publishEvent(any());
    }

    // Add more tests as needed
}
