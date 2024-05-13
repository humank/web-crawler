package com.amazonaws.devtx.webcrawler.domain.tests;

import com.amazonaws.devtx.webcrawler.domain.Website;
import com.amazonaws.devtx.webcrawler.domain.WebsiteRepository;
import com.amazonaws.devtx.webcrawler.domain.WebsiteSpecification;
import com.amazonaws.devtx.webcrawler.infrastructure.persistence.WebsiteRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WebsiteRepositoryTest {
    private WebsiteRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new WebsiteRepositoryImpl();
    }

    @Test
    public void testSaveAndFindAll() {
        Website website1 = new Website("https://example.com","test1");
        Website website2 = new Website("https://example.org","test2");

        repository.save(website1);
        repository.save(website2);

        List<Website> allWebsites = repository.findAll();
        assertEquals(2, allWebsites.size());
        assertTrue(allWebsites.contains(website1));
        assertTrue(allWebsites.contains(website2));
    }

    @Test
    public void testFindBySpecification() {
        Website website1 = new Website("https://example.com","test1");
        Website website2 = new Website("https://example.org","test2");
        Website website3 = new Website("https://test.example.com","test3");

        repository.save(website1);
        repository.save(website2);
        repository.save(website3);

        WebsiteSpecification exampleSpec = new WebsiteSpecification("example.com");
        List<Website> exampleWebsites = repository.findBySpecification(exampleSpec);
        assertEquals(2, exampleWebsites.size());
        assertTrue(exampleWebsites.contains(website1));
        assertFalse(exampleWebsites.contains(website2));
        assertTrue(exampleWebsites.contains(website3));
    }

    @Test
    public void testFindByUrl() {
        Website website1 = new Website("https://example.com","test1");
        Website website2 = new Website("https://example.org","test2");

        repository.save(website1);
        repository.save(website2);

        Website foundWebsite = repository.findByUrl("https://example.com");
        assertEquals(website1, foundWebsite);

        foundWebsite = repository.findByUrl("https://unknown.com");
        assertNull(foundWebsite);
    }

    @Test
    public void testDelete() {
        Website website1 = new Website("https://example.com","test1");
        Website website2 = new Website("https://example.org","test2");

        repository.save(website1);
        repository.save(website2);

        repository.delete(website1);

        List<Website> allWebsites = repository.findAll();
        assertEquals(1, allWebsites.size());
        assertFalse(allWebsites.contains(website1));
        assertTrue(allWebsites.contains(website2));
    }

    // Add more tests as needed
}
