package com.url.urlshort.service;


import com.url.urlshort.domain.Url;
import com.url.urlshort.repository.UrlRepository;
import com.url.urlshort.web.dto.UrlForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final ConvertService convertService;
    private String urlPrefix = "https://mus.in/";

    @Transactional
    public UrlForm makeShortUrl(UrlForm urlForm) {

        String convertedUrl = "";

        Optional<Url> url = urlRepository.findByUrl(urlForm.getUrl());

        if(url.isPresent()) {
            url.get().setRequestCount(url.get().getRequestCount() + 1);
            UrlForm newUrlForm = new UrlForm();
            newUrlForm.setUrl(urlPrefix + convertService.encode(url.get().getId()));
            return newUrlForm;
        }

        Url newUrl = new Url();
        newUrl.setUrl(urlForm.getUrl());
        newUrl.setRequestCount(1L);

        Url savedUrl = urlRepository.save(newUrl);

        convertedUrl = convertService.encode(savedUrl.getId());

        UrlForm urlShortForm = new UrlForm();
        urlShortForm.setUrl(urlPrefix + convertedUrl);

        return urlShortForm;
    }

    public UrlForm getUrl(String shortUrl) {
        Long id = convertService.decode(shortUrl);
        Url url = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found " + shortUrl));

        UrlForm urlForm = new UrlForm();
        urlForm.setUrl(url.getUrl());

        return urlForm;
    }

}
