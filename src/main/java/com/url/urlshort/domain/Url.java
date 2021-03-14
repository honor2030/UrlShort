package com.url.urlshort.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter @Setter
@SequenceGenerator(
        name = "URL_SEQ_GENERATOR",
        sequenceName = "URL_SEQ",
        initialValue = 1, allocationSize = 50)
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "URL_SEQ_GENERATOR")
    private Long Id;

    private String url;

    private Long requestCount;
}
