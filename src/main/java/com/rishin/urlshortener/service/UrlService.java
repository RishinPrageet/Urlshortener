package com.rishin.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishin.urlshortener.model.Url;
import com.rishin.urlshortener.repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository){
        this.urlRepository=urlRepository;
    }

    public Url getUrlByShortCode(String shortCode) {
        return urlRepository.findUrlByShortCode(shortCode)
                            .orElseThrow(() -> new RuntimeException("Short code not found"));
    }
    public String createShortCode(String originalUrl){
        
    }


}
