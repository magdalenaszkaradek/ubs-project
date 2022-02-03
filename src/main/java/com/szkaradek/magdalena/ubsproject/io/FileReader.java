package com.szkaradek.magdalena.ubsproject.io;

import java.io.*;
import java.util.Objects;

public class FileReader {

    public static String readFile(String filePath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            //todo handle exception -> ex. create custom exception
            e.printStackTrace();
        }
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(fileInputStream)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading from file");
            e.printStackTrace();
            //todo handle exception
        }
        return resultStringBuilder.toString();
    }
}
