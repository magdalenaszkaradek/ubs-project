package com.szkaradek.magdalena.ubsproject.domain;

import java.util.*;

public class VowelsAverageResolver {

    public VowelsAverageResolver() {
    }

    public Map<WordKey, Average> getWordAverageMap(List<String> words) {
        Map<WordKey, Average> averageVowelsNumber = new HashMap<>();

        for (String word : words) {
            Set<Character> vowels = new HashSet<>();
            WordKey wordKey = new WordKey();
            int length = word.length();
            wordKey.setLength(length);

            int vowelsCount = (int) word.chars()
                    .mapToObj(c -> (char) c)
                    .filter(VowelsAverageResolver::isVowel)
                    .peek(vowels::add)
                    .count();

            wordKey.setVowels(vowels);

            Average averageObject = averageVowelsNumber.computeIfAbsent(wordKey, key -> new Average());
            averageObject.add(vowelsCount);
        }
        return averageVowelsNumber;
    }

    private static boolean isVowel(char character) {
        Set<Character> vowels = Set.of('a', 'o', 'i', 'e', 'u');
        return vowels.contains(character);
    }
}
