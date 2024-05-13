package com.amazonaws.devtx.webcrawler.domain;

public class WebsiteSpecification implements Specification<Website> {
    private final String domainName;

    public WebsiteSpecification(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public boolean isSatisfiedBy(Website website) {
        return website.getUrl().contains(domainName);
    }
}
