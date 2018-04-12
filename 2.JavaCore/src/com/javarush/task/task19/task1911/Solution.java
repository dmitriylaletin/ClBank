package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleOut);

        System.out.println(result.toUpperCase());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
