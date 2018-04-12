package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFile =fileNameReader.readLine();
            String secondFile =fileNameReader.readLine();
            fileNameReader.close();

            try (BufferedReader stringReader = new BufferedReader(new FileReader(firstFile));
                 BufferedWriter stringWriter = new BufferedWriter(new FileWriter(secondFile)) ) {

                StringBuilder inputStrings = new StringBuilder();

                while (stringReader.ready()){
                    inputStrings = inputStrings.append(stringReader.readLine());
                }

                String outputStrings = inputStrings.toString().replaceAll("[^A-Za-z0-9\\s]", "");

                stringWriter.write(outputStrings);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
