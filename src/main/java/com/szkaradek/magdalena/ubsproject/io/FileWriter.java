package com.szkaradek.magdalena.ubsproject.io;

import java.io.IOException;

public class FileWriter {

    public static void writeToOutputFile(String text) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter("OUTPUT.txt")) {
            fileWriter.write(text);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
