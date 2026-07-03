package com.rishin.urlshortener.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rishin.urlshortener.repository.UrlRepository;


@Service
public class ClickCountService {
    private final UrlRepository urlRepository;

    public ClickCountService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
    @Async
    @Transactional
    public void increment(String shortCode){
        urlRepository.incrementClickCount(shortCode);
    }
    
}
