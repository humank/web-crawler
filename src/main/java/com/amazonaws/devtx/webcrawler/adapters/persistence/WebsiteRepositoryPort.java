package com.amazonaws.devtx.webcrawler.adapters.persistence;


import com.amazonaws.devtx.webcrawler.domain.Specification;
import com.amazonaws.devtx.webcrawler.domain.Website;

import java.util.List;

public interface WebsiteRepositoryPort {
    void save(Website website);
    List<Website> findAll();
    List<Website> findBySpecification(Specification<Website> specification);
    Website findByUrl(String url);
    void delete(Website website);
}
