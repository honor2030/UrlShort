package com.url.urlshort.repository;

import com.url.urlshort.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findById(Long id);
    Optional<Url> findByUrl(String Url);

}
