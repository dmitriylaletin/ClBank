package com.javarush.task.task19.task1925;

/* 
Длинные слова
Dima dmitriy love sea Anastasia
Room number serenities
Adik never forgive
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();
        List<String> inputWords = new LinkedList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {

            while (fileReader.ready()){
                inputWords = Arrays.asList(fileReader.readLine().split(" "));
                for (String s : inputWords) {
                    if (s.length() > 6) temp = temp.append(s+",");
                }
            }
            fileWriter.write(temp.deleteCharAt(temp.length()-1).toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
