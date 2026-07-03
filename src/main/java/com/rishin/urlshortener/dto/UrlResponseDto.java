package com.rishin.urlshortener.dto;

public class UrlResponseDto {
    private String originalUrl;
    private String shortCode;

    public UrlResponseDto(String originalUrl, String shortCode){
        this.originalUrl=originalUrl;
        this.shortCode = shortCode;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
