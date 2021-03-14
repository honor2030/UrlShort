package com.url.urlshort.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import com.url.urlshort.domain.Url;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//  추후 확장을 위한 DTO 생성
@Getter @Setter
@ToString
public class UrlForm {

    @NotBlank(message = "URL 값이 필요합니다")
    @Pattern(regexp = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)" +
            "?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$",
            message = "유효한 URL 값이 필요합니다")
    private String url;
}
