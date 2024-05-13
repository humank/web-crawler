package com.amazonaws.devtx.webcrawler.adapters.eventhandlers;


import com.amazonaws.devtx.webcrawler.domain.events.WebsiteEvent;

public interface WebsiteEventHandlerPort {
    void handleWebsiteEvent(WebsiteEvent event);
}
