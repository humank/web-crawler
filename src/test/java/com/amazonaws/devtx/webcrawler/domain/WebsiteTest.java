package com.amazonaws.devtx.webcrawler.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebsiteTest {

    @Test
    public void testWebsiteConstructor() {
        String url = "https://example.com";
        String name = "Example Website";
        Website website = new Website(url,name);

        assertEquals(url, website.getUrl());
        assertEquals(name, website.getName());
    }

    @Test
    public void testWebsiteEquality() {
        Website website1 = new Website("https://example.com","test1");
        Website website2 = new Website("https://example.com","test2");
        Website website3 = new Website("https://example.org","test3");

        assertEquals(website1, website2);
        assertNotEquals(website1, website3);
    }

    // Add more tests as needed
}
