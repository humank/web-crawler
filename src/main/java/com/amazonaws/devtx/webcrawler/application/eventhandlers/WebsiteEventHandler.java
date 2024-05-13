package com.amazonaws.devtx.webcrawler.application.eventhandlers;

import com.amazonaws.devtx.webcrawler.domain.Website;
import com.amazonaws.devtx.webcrawler.domain.events.WebsiteEvent;
import org.springframework.context.event.EventListener;

public class WebsiteEventHandler {

    @EventListener
    public void handleWebsiteEvent(WebsiteEvent event) {
        switch (event.getEventType()) {
            case WEBSITE_CRAWLED:
                handleWebsiteCrawled(event.getWebsite());
                break;
            case WEBSITE_UPDATED:
                handleWebsiteUpdated(event.getWebsite());
                break;
            case WEBSITE_DELETED:
                handleWebsiteDeleted(event.getWebsite());
                break;
        }
    }

    private void handleWebsiteCrawled(Website website) {
        // Implement logic for handling website crawled event
        System.out.println("Website crawled: " + website.getUrl());
    }

    private void handleWebsiteUpdated(Website website) {
        // Implement logic for handling website updated event
        System.out.println("Website updated: " + website.getUrl());
    }

    private void handleWebsiteDeleted(Website website) {
        // Implement logic for handling website deleted event
        System.out.println("Website deleted: " + website.getUrl());
    }
}
