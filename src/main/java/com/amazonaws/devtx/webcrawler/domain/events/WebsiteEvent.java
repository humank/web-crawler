package com.amazonaws.devtx.webcrawler.domain.events;

import com.amazonaws.devtx.webcrawler.domain.Website;

public class WebsiteEvent {
    private final Website website;
    private final EventType eventType;

    public WebsiteEvent(Website website, EventType eventType) {
        this.website = website;
        this.eventType = eventType;
    }

    public Website getWebsite() {
        return website;
    }

    public EventType getEventType() {
        return eventType;
    }

    public enum EventType {
        WEBSITE_CRAWLED,
        WEBSITE_UPDATED,
        WEBSITE_DELETED
    }
}
