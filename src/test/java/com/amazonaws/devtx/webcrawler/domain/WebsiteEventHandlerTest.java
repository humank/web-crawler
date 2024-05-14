package com.amazonaws.devtx.webcrawler.domain;

import org.junit.jupiter.api.Test;

import com.amazonaws.devtx.webcrawler.domain.events.WebsiteEvent;
import com.amazonaws.devtx.webcrawler.application.eventhandlers.WebsiteEventHandler;

public class WebsiteEventHandlerTest {

    @Test
    public void testHandleWebsiteEvent_WebsiteCrawled() {
        WebsiteEventHandler handler = new WebsiteEventHandler();
        Website website = new Website("https://www.youtube.com/watch?v=pfAlmkzyaJQ","test");
        WebsiteEvent event = new WebsiteEvent(website, WebsiteEvent.EventType.WEBSITE_CRAWLED);

        handler.handleWebsiteEvent(event);

        // Verify that handleWebsiteCrawled was called
        // (You can't really verify the output here, but you can mock external dependencies if needed)
    }

    @Test
    public void testHandleWebsiteEvent_WebsiteUpdated() {
        WebsiteEventHandler handler = new WebsiteEventHandler();
        Website website = new Website("https://www.youtube.com/watch?v=pfAlmkzyaJQ","test");
        WebsiteEvent event = new WebsiteEvent(website, WebsiteEvent.EventType.WEBSITE_UPDATED);

        handler.handleWebsiteEvent(event);

        // Verify that handleWebsiteUpdated was called
    }

    @Test
    public void testHandleWebsiteEvent_WebsiteDeleted() {
        WebsiteEventHandler handler = new WebsiteEventHandler();
        Website website = new Website("https://www.youtube.com/watch?v=pfAlmkzyaJQ", "Kim-test");
        WebsiteEvent event = new WebsiteEvent(website, WebsiteEvent.EventType.WEBSITE_DELETED);

        handler.handleWebsiteEvent(event);

        // Verify that handleWebsiteDeleted was called
    }
}
