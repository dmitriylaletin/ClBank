package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

      String fileName = args[0];
      int englishCharCounter = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z]");

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            char data = (char)fileInputStream.read();
            Matcher matcher = pattern.matcher(Character.toString(data));
            if (matcher.matches()) englishCharCounter++;
        }

        System.out.println(englishCharCounter);
        fileInputStream.close();
    }
}
