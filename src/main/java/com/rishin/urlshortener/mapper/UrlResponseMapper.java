package com.rishin.urlshortener.mapper;

import org.springframework.stereotype.Component;

import com.rishin.urlshortener.dto.UrlResponseDto;
import com.rishin.urlshortener.model.Url;

@Component
public class UrlResponseMapper {

    public UrlResponseDto toDto(Url url) {
        return new UrlResponseDto(
                url.getOriginalUrl(),
                url.getShortCode()
        );
    }
}