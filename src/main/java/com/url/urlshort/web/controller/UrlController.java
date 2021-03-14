package com.url.urlshort.web.controller;



import com.url.urlshort.service.UrlService;
import com.url.urlshort.web.dto.UrlForm;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlConvertService;


    @PostMapping(value = "/url")
    public UrlForm create(@Valid @RequestBody UrlForm urlForm) {

        return urlConvertService.makeShortUrl(urlForm);
    }

    @GetMapping(value = "/url/{shortUrl}")
    public UrlForm redirect(@PathVariable String shortUrl) {

        return urlConvertService.getUrl(shortUrl);
    }
}
