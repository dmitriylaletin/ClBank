package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args)  {
        String file1 =args[0];
        String file2 =args[1];
        List<String> inputWords = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2))) {

            while (bufferedReader.ready()){
                List<String> list = Arrays.asList(bufferedReader.readLine().split(" "));
                inputWords.addAll(list);
            }
            for (String s : inputWords ) {
                if (s.replaceAll("\\D","").length() > 0){
                    bufferedWriter.write(s+" ");
                    System.out.println(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
