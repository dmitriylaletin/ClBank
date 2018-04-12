package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {

    }

    public static class PersonScannerAdapter implements PersonScanner {

       private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String[] guy = fileScanner.nextLine().split(" ", 4);
            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = null;
            try {
                date = dateFormat.parse(guy[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(guy[1], guy[2], guy[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
