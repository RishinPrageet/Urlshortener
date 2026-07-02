package com.rishin.urlshortener.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishin.urlshortener.mapper.UrlMapper;
import com.rishin.urlshortener.model.Url;
import com.rishin.urlshortener.repository.UrlRepository;
import com.rishin.urlshortener.service.strategy.ShortCodeGenerator;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ShortCodeGenerator shortCodeGenerator;
    private final UrlMapper urlMapper;

    @Autowired
    public UrlService(UrlRepository urlRepository,ShortCodeGenerator shortCodeGenerator,UrlMapper urlMapper){
        this.urlRepository=urlRepository;
        this.shortCodeGenerator = shortCodeGenerator;
        this.urlMapper = urlMapper;
    }

    public Url getUrlByShortCode(String shortCode) {
        return urlRepository.findUrlByShortCode(shortCode)
                            .orElseThrow(() -> new RuntimeException("Short code not found"));
    }
    public String createShortCode(String originalUrl){
        String shortCode;
        do {
            String shortCode = shortCodeGenerator.generate();
        } while(urlRepository.findUrlByShortCode(shortCode).isPresent());
        Url url = urlMapper(originalUrl,shortCode);
        return urlRepository.save(url);
    }


}
