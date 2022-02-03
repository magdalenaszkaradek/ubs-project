package com.szkaradek.magdalena.ubsproject.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.szkaradek.magdalena.ubsproject.domain.WordsExtractor.getWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsExtractorTest {

    @Test
    void getWords_nullAsInput() {
        List<String> words = getWords(null);

        assertEquals(0, words.size());
    }

    @Test
    void getWords_emptyInput() {
        List<String> words = getWords("");

        assertEquals(0, words.size());
    }

    @Test
    void getWords_whitespaceInput() {
        List<String> words = getWords(" ");

        assertEquals(0, words.size());
    }

    @Test
    void getWords_oneWord() {
        List<String> words = getWords("element");

        assertEquals(1, words.size());
    }

    @Test
    void getWords_twoWords() {
        List<String> words = getWords("first, second");

        assertEquals(2, words.size());
    }

    @Test
    void getWords_twoWordsWithDot() {
        List<String> words = getWords("first second.");

        assertEquals(2, words.size());
    }

    @Test
    void getWords_twoWordsStartingWithSpace() {
        List<String> words = getWords(" first second");

        assertEquals(2, words.size());
    }

    @Test
    void getWords_twoWordsStartingWithSpecialCharacter() {
        List<String> words = getWords("$ first second");

        assertEquals(2, words.size());
    }

    @Test
    void getWords_twoWordsWithHyphen() {
        List<String> words = getWords("first-second");

        assertEquals(2, words.size());
    }
}