package com.szkaradek.magdalena.ubsproject;

import com.szkaradek.magdalena.ubsproject.domain.Average;
import com.szkaradek.magdalena.ubsproject.domain.WordKey;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.szkaradek.magdalena.ubsproject.OutputFormatter.prepareOutputFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputFormatterTest {

    @Test
    void prepareOutputFormat_nullAsInput() {
        String formattedString = prepareOutputFormat(null);

        assertEquals("", formattedString);
    }

    @Test
    void prepareOutputFormat_emptyMapAsInput() {
        String formattedString = prepareOutputFormat(new HashMap<>());

        assertEquals("", formattedString);
    }

    @Test
    void prepareOutputFormat_oneElement() {
        Map<WordKey, Average> averageMap = Map.of(word(5, Set.of('a', 'e')), average(2));

        String formattedString = prepareOutputFormat(averageMap);

        assertTrue(formattedString.contains("({a, e}, 5) -> 2.0"));
        assertEquals(1, formattedString.lines().count());
    }

    @Test
    void prepareOutputFormat_twoElements() {
        Map<WordKey, Average> averageMap = Map.of(
                word(5, Set.of('a', 'e')), average(2),
                word(6, Set.of('a', 'o')), average(3)
        );

        String formattedString = prepareOutputFormat(averageMap);

        assertTrue(formattedString.contains("({a, e}, 5) -> 2.0"));
        assertTrue(formattedString.contains("({a, o}, 6) -> 3.0"));
        assertEquals(2, formattedString.lines().count());
    }

    private WordKey word(int length, Set<Character> vowels) {
        WordKey wordKey = new WordKey();
        wordKey.setLength(length);
        wordKey.setVowels(vowels);

        return wordKey;
    }

    private Average average(int averageNumber) {
        Average average = new Average();
        average.add(averageNumber);
        return average;
    }
}