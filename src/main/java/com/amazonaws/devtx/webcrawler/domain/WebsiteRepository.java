package com.amazonaws.devtx.webcrawler.domain;

import java.util.List;

public interface WebsiteRepository {
    void save(Website website);
    List<Website> findAll();
    List<Website> findBySpecification(Specification<Website> specification);
    Website findByUrl(String url);
    void delete(Website website);
}
