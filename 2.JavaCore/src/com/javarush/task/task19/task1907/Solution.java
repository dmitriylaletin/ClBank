package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int worldCounter = 0;
        String fileStrings = "";
        try {
            String filename = bufferedReader.readLine();
            bufferedReader.close();
            try (FileReader fileReader = new FileReader(filename)) {
                while (fileReader.ready()){
                    int fileChar = fileReader.read();
                    fileStrings = fileStrings + ((char)fileChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] allFileStrings = fileStrings.split("[^A-Z,a-z]");
        worldCounter = Collections.frequency(Arrays.asList(allFileStrings), "world");
        System.out.println(worldCounter);

    }
}
