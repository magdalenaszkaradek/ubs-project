package com.szkaradek.magdalena.ubsproject.domain;

import com.szkaradek.magdalena.ubsproject.domain.Average;
import com.szkaradek.magdalena.ubsproject.domain.VowelsAverageResolver;
import com.szkaradek.magdalena.ubsproject.domain.WordKey;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VowelsAverageResolverTest {

    @Test
    void getAverageNumber_threeItems() {
        VowelsAverageResolver vowelsAverageResolver = new VowelsAverageResolver();
        List<String> words = List.of("sample", "simple", "text");
        Map<WordKey, Average> wordAverageMap = vowelsAverageResolver.getWordAverageMap(words);

        assertEquals(3, wordAverageMap.size());
        WordKey wordKey = new WordKey();
        wordKey.setLength(6);
        wordKey.setVowels(Set.of('a', 'e'));
        assertNotNull(wordAverageMap.get(wordKey));
        assertEquals(2.0, wordAverageMap.get(wordKey).getValue());
    }

    @Test
    void getAverageNumber_emptyList() {
        VowelsAverageResolver vowelsAverageResolver = new VowelsAverageResolver();
        List<String> words = Collections.emptyList();
        Map<WordKey, Average> wordAverageMap = vowelsAverageResolver.getWordAverageMap(words);

        assertEquals(0, wordAverageMap.size());
    }
}
