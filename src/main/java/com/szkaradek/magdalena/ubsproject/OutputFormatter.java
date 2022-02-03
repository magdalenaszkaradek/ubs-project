package com.szkaradek.magdalena.ubsproject;

import com.szkaradek.magdalena.ubsproject.domain.Average;
import com.szkaradek.magdalena.ubsproject.domain.WordKey;

import java.util.Map;

public class OutputFormatter {

    public static String prepareOutputFormat(Map<WordKey, Average> averageVowelsNumber) {
        if (averageVowelsNumber == null || averageVowelsNumber.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<WordKey, Average> element : averageVowelsNumber.entrySet()) {
            stringBuilder.append("({");
            stringBuilder.append(element.getKey().getVowels().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
            stringBuilder.append("}, ");
            stringBuilder.append(element.getKey().getLength());
            stringBuilder.append(") -> ");
            stringBuilder.append(element.getValue().getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
