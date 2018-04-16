package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
C:\DevInfo\test.txt
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileNAme = bufferedReader.readLine();
            bufferedReader.close();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileNAme))) {
            while (fileReader.ready()) {
            String inputString = fileReader.readLine();
            List<String> inputList = Arrays.asList(inputString.split(" "));
            int wordCounter = 0;
                for (String s : words) { wordCounter = wordCounter + Collections.frequency(inputList, s); }
            if (wordCounter == 2) System.out.println(inputString);
            }
        }
    }
}
