package com.rishin.urlshortener.dto;

public class UrlResponseDto {
    private String originalUrl;
    private String shortCode;

    public String getOrginalUrl() {
        return originalUrl;
    }
    public void setOrginalUrl(String orginalUrl) {
        this.originalUrl = orginalUrl;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
