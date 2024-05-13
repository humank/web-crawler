package com.amazonaws.devtx.webcrawler.domain;

import java.util.Objects;

public class Website {
    private final String url;
    private final String name;

    public Website(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return Objects.equals(url, website.url) &&
                Objects.equals(name, website.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name);
    }
}
