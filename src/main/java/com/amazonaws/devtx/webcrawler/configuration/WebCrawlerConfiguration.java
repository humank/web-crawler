package com.amazonaws.devtx.webcrawler.configuration;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.devtx.webcrawler.application.eventhandlers.WebsiteEventHandler;
import com.amazonaws.devtx.webcrawler.domain.services.WebCrawlerServiceImpl;
import com.amazonaws.devtx.webcrawler.infrastructure.persistence.WebsiteRepositoryImpl;

@Configuration
public class WebCrawlerConfiguration {

    @Bean
    public WebsiteRepositoryImpl websiteRepository() {
        return new WebsiteRepositoryImpl();
    }

    @Bean
    public WebsiteEventHandler websiteEventHandler() {
        return new WebsiteEventHandler();
    }

    @Bean
    public WebCrawlerServiceImpl webCrawlerService(WebsiteRepositoryImpl websiteRepository, ApplicationEventPublisher eventPublisher) {
        return new WebCrawlerServiceImpl(websiteRepository, eventPublisher);
    }

}
