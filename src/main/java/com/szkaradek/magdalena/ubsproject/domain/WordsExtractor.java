package com.szkaradek.magdalena.ubsproject.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordsExtractor {

    public static List<String> getWords(String text)  {
        if(text == null || text.strip().equals("")){
            return Collections.emptyList();
        }

        return Arrays.asList(text.toLowerCase().replaceAll("[^a-z]", " ").strip().split("\\s+"));
    }
}
