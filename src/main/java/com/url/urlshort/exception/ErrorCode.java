package com.url.urlshort.exception;

import lombok.Getter;

public enum ErrorCode {
    NOT_BLANK("ERROR_0001","URL 값이 필요합니다"),
    NOT_VALID("ERROR_0002","유효한 URL 값이 필요합니다"),
    ENTITY_NOT_FOUND("ERROR_1002","올바른 URL을 입력해주세요");

    @Getter
    private String code;

    @Getter
    private String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
