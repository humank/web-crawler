package com.amazonaws.devtx.webcrawler.infrastructure.persistence;

import com.amazonaws.devtx.webcrawler.domain.Specification;
import com.amazonaws.devtx.webcrawler.domain.Website;
import com.amazonaws.devtx.webcrawler.domain.WebsiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebsiteRepositoryImpl implements WebsiteRepository {
    private final List<Website> websites;

    public WebsiteRepositoryImpl() {
        this.websites = new ArrayList<>();
    }

    public WebsiteRepositoryImpl(List<Website> websites) {
        this.websites = new ArrayList<>(websites);
    }

    @Override
    public void save(Website website) {
        websites.add(website);
    }

    @Override
    public List<Website> findAll() {
        return new ArrayList<>(websites);
    }

    @Override
    public List<Website> findBySpecification(Specification<Website> specification) {
        return websites.stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Override
    public Website findByUrl(String url) {
        return websites.stream()
                .filter(w -> w.getUrl().equals(url))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Website website) {
        websites.remove(website);
    }
}
