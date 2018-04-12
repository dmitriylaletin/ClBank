package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileToRead = bufferedReader.readLine();
            String fileToWrite = bufferedReader.readLine();
            bufferedReader.close();
            String allFileString = "";

            try (BufferedReader fileStringsReader = new BufferedReader(new FileReader(fileToRead));
                 BufferedWriter fileStringsWriter = new BufferedWriter(new FileWriter(fileToWrite))) {


                while (fileStringsReader.ready()){
                    allFileString = allFileString +(fileStringsReader.readLine());
                }

                Pattern p = Pattern.compile("\\b\\d+\\b");
                Matcher m = p.matcher(allFileString);
                StringBuilder allDigitStrings = new StringBuilder();
                while (m.find()){
                    allDigitStrings = allDigitStrings.append(m.group() + " ");
                }
                fileStringsWriter.write(allDigitStrings.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
