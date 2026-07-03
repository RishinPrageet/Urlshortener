package com.rishin.urlshortener.mapper;



import org.springframework.stereotype.Component;

import com.rishin.urlshortener.model.Url;

@Component
public class UrlMapper {

    public Url toEntity(String originalUrl, String shortCode) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        return url;
    }
}