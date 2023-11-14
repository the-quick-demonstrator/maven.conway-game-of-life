package com.github.curriculeon;

import java.util.Arrays;
import java.util.StringJoiner;

public class JadenCasing {
    public String toJadenCase(String input) {
        final String delimiter = " ";
        final StringJoiner sj = new StringJoiner(delimiter);
        Arrays.stream(input.split(delimiter)).map(word -> {
            final StringBuilder sb = new StringBuilder(word.toLowerCase());
            final Character firstLetter = word.charAt(0);
            sb.setCharAt(0, Character.toUpperCase(firstLetter));
            return sb.toString();
        }).forEach(sj::add);
        return sj.toString();
    }
}
