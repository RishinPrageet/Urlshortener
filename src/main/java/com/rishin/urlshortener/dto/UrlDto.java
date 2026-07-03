package com.rishin.urlshortener.dto;

public class UrlDto {
    private String originalUrl;
    private String shortCode;

    public String getOrginalUrl() {
        return originalUrl;
    }
    public void setOrginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    
}
