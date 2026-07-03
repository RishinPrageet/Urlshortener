package com.rishin.urlshortener.dto;
import jakarta.validation.constraints.NotBlank;
public class CreateRequestUrlDto {
    @NotBlank
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
