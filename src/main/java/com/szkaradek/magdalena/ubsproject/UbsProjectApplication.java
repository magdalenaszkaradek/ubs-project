package com.szkaradek.magdalena.ubsproject;

import com.szkaradek.magdalena.ubsproject.domain.Average;
import com.szkaradek.magdalena.ubsproject.domain.VowelsAverageResolver;
import com.szkaradek.magdalena.ubsproject.domain.WordKey;

import java.util.List;
import java.util.Map;

import static com.szkaradek.magdalena.ubsproject.OutputFormatter.prepareOutputFormat;
import static com.szkaradek.magdalena.ubsproject.domain.WordsExtractor.getWords;
import static com.szkaradek.magdalena.ubsproject.io.FileReader.readFile;
import static com.szkaradek.magdalena.ubsproject.io.FileWriter.writeToOutputFile;

public class UbsProjectApplication {

    public static void main(String[] args) {
        getAverageNumber(args[0]);
    }

    public static void getAverageNumber(String filePath) {
        String content = readFile(filePath);

        List<String> words = getWords(content);
        VowelsAverageResolver vowelsAverageNumber = new VowelsAverageResolver();
        Map<WordKey, Average> averageVowelsNumber = vowelsAverageNumber.getWordAverageMap(words);
        writeToOutputFile(prepareOutputFormat(averageVowelsNumber));
    }
}
