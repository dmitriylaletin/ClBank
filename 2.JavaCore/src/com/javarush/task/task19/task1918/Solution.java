package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        bufferedReader.close();

        StringBuilder inputSB = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                inputSB.append(fileReader.readLine());
            }
        }
        String inputString = inputSB.toString();

        String startTag = "<" + args[0];
        String endTag = "</" + args[0] + ">";

        Pattern startPattern = Pattern.compile(startTag);
        Pattern endPattern = Pattern.compile(endTag);

        List<Integer> openTagCoordinates = new ArrayList<>();
        List<Integer> closeTagCoordinates = new ArrayList<>();

        while (inputString.length() > 0) {

            Matcher start = startPattern.matcher(inputString);
            Matcher end = endPattern.matcher(inputString);

            while (start.find()) {
                int starter = start.start();
                openTagCoordinates.add(starter);
            }

            while (end.find()) {
                int ender = end.end();
                closeTagCoordinates.add(ender);
            }

            int openBeforeCloseTagcount = 0;
            for (Integer integer : openTagCoordinates) {
                if (integer < closeTagCoordinates.get(0)) openBeforeCloseTagcount++;
            }

            int catchedTagsSubstringIndex = closeTagCoordinates.get(openBeforeCloseTagcount - 1);

            for (int x = 0, y = openBeforeCloseTagcount - 1; x < openBeforeCloseTagcount; x++, y--) {
                String s = inputString.substring(openTagCoordinates.get(x), closeTagCoordinates.get(y));
                System.out.println(s);
            }
            openTagCoordinates.clear();
            closeTagCoordinates.clear();
            inputString = inputString.substring(catchedTagsSubstringIndex);
        }
    }
}
