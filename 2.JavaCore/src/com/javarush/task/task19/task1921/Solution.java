package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
C:\DevInfo\test.txt
Иванов Иван Иванович 31-12-1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while (bufferedReader.ready()){
            String input = bufferedReader.readLine();
             String name = input.replaceAll("[\\d]","").trim();
             String date = input.replaceAll("^\\D+","").trim();
             SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                PEOPLE.add(new Person(name, sdf.parse(date)));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
