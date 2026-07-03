package com.rishin.urlshortener.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rishin.urlshortener.dto.CreateRequestUrlDto;
import com.rishin.urlshortener.dto.UrlResponseDto;
import com.rishin.urlshortener.model.Url;
import com.rishin.urlshortener.service.UrlService;
import com.rishin.urlshortener.mapper.UrlResponseMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;
    private final UrlResponseMapper urlResponseMapper;

    public UrlController(UrlService urlService, UrlResponseMapper urlResponseMapper) {
        this.urlService = urlService;
        this.urlResponseMapper = urlResponseMapper;
    }

    @PostMapping
    public ResponseEntity<UrlResponseDto> createShortCode(
            @Valid @RequestBody CreateRequestUrlDto requestUrlDto) {

        Url url = urlService.createShortCode(requestUrlDto.getOriginalUrl());

         return ResponseEntity.status(HttpStatus.CREATED)
        .body(urlResponseMapper.toDto(url));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        Url url = urlService.getUrlByShortCode(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }
}