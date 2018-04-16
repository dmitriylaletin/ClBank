package com.javarush.task.task19.task1926;

/* 
Перевертыши
C:\DevInfo\test.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader filenameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = filenameReader.readLine();
            filenameReader.close();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) {
                    StringBuilder temp = new StringBuilder(fileReader.readLine());
                    System.out.println(temp.reverse());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
