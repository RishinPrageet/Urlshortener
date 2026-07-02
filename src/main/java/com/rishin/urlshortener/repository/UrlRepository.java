package com.rishin.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishin.urlshortener.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
    Optional<Url> findUrlByShortCode(String shortCode);
    Optional<Url> findUrlByOriginalUrl(String originalUrl);

}
