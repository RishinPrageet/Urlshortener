package com.rishin.urlshortener.service.strategy;

import org.springframework.stereotype.Component;
@Component
public interface ShortCodeGenerator {
    public String generate();
}
