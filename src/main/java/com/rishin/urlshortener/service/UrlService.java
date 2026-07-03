package com.rishin.urlshortener.service;

import org.springframework.stereotype.Service;

import com.rishin.urlshortener.mapper.UrlMapper;
import com.rishin.urlshortener.model.Url;
import com.rishin.urlshortener.repository.UrlRepository;
import com.rishin.urlshortener.service.strategy.ShortCodeGenerator;
import com.rishin.urlshortener.util.UrlUtils;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ShortCodeGenerator shortCodeGenerator;
    private final UrlMapper urlMapper;
    private final ClickCountService clickCountService;

   
    public UrlService(UrlRepository urlRepository,ShortCodeGenerator shortCodeGenerator,UrlMapper urlMapper,ClickCountService clickCountService){
        this.urlRepository=urlRepository;
        this.shortCodeGenerator = shortCodeGenerator;
        this.urlMapper = urlMapper;
        this.clickCountService=clickCountService;
    }

public Url getUrlByShortCode(String shortCode) {
    Url url = urlRepository.findUrlByShortCode(shortCode)
                           .orElseThrow(() -> new RuntimeException("Short code not found"));
    clickCountService.increment(shortCode); // fire-and-forget
    return url;
}
    public Url createShortCode(String originalUrl){
            originalUrl = UrlUtils.normalizeUrl(originalUrl);

            if (!UrlUtils.isValidUrl(originalUrl)) {
                throw new IllegalArgumentException("Invalid URL");
            }
        String shortCode;
        do {
            shortCode = shortCodeGenerator.generate();
        } while(urlRepository.findUrlByShortCode(shortCode).isPresent());
        Url url = urlMapper.toEntity(originalUrl,shortCode);
        return urlRepository.save(url);
    }


}
