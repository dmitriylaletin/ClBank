package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        int printedStringsCounter = 0;

        PrintStream original = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(byteArrayOutputStream);
        System.setOut(myOut);

        testString.printSomething();

        String[] catchedStringsArray = byteArrayOutputStream.toString().split("\\n");

        System.setOut(original);

        for (int i = 0; i < catchedStringsArray.length;) {
            if (printedStringsCounter != 2) {
                System.out.println(catchedStringsArray[i]);
                printedStringsCounter++;
                i++;
            } else {
                System.out.println("JavaRush - курсы Java онлайн");
                printedStringsCounter = 0;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
