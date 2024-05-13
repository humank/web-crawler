package com.amazonaws.devtx.webcrawler.domain;

public interface Specification<T> {
    boolean isSatisfiedBy(T candidate);
}
