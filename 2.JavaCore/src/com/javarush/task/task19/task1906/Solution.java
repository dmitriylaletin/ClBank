package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        String firstFileName;
        String secondFileName;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        }

        try (FileReader fileReader = new FileReader(firstFileName); FileWriter fileWriter = new FileWriter(secondFileName)) {
            int count = 1;
            while (fileReader.ready()) {
                int chr = fileReader.read();
                if (count % 2 == 0) {
                    fileWriter.write(chr);
                }
                count++;
            }
        }
    }
}