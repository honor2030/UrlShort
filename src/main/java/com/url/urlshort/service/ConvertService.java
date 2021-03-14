package com.url.urlshort.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    private static final String base62String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] base62Characters = base62String.toCharArray();
    private int base62StringLen = base62Characters.length;

    public String encode(long input){
        StringBuilder encodedString = new StringBuilder();

        while (input > 0) {
            encodedString.append(base62Characters[(int) (input % base62StringLen)-1]);
            input = input / base62StringLen;
        }

        return encodedString.reverse().toString();
    }

    public long decode(String input) {
        char[] characters = input.toCharArray();
        int length = characters.length;

        int decoded = 1;

        int counter = 1;
        for (int i = 0; i < length; i++) {
            decoded += base62String.indexOf(characters[i]) * Math.pow(base62StringLen, length - counter);
            counter++;
        }
        return decoded;
    }

}
