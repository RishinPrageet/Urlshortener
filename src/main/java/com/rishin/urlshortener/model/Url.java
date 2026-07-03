package com.rishin.urlshortener.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

import jakarta.persistence.Table;

import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(indexes={
    @Index(name ="idx_shortcode",columnList="shortCode")
})
public class Url{

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String originalUrl; 

@Column(nullable =false, unique = true)
private String shortCode;

@Column(nullable = false)
private long clickCount = 0;

@Column(nullable = false, updatable = false)
private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getClickCount(){
        return this.clickCount;
    }

    public void setClickCount(Long clickCount){
        this.clickCount = clickCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }




}