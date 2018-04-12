package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFile = bufferedReader.readLine();
            String secondFile = bufferedReader.readLine();
            bufferedReader.close();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile))) {

                StringBuilder inputStrings = new StringBuilder();
                while (fileReader.ready()){
                    inputStrings = inputStrings.append(fileReader.readLine());
                }
                fileWriter.write(inputStrings.toString().replaceAll("[.]","!"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
