package com.szkaradek.magdalena.ubsproject.domain;

import lombok.Data;

import java.util.Set;

@Data
public class WordKey {
    Set<Character> vowels;
    int length;
}
