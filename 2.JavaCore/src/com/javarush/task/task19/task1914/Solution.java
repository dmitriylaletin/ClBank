package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(original);

        String[] mathResut = result.replaceAll("(\\D+$)","").split("\\s");

        switch (mathResut[1]){
            case "+" :
                int sum = Integer.parseInt(mathResut[0]) + Integer.parseInt(mathResut[2]);
                System.out.println(String.format("%s + %s = %d",mathResut[0],mathResut[2],sum));
                break;
            case "-" :
                int min = Integer.parseInt(mathResut[0]) - Integer.parseInt(mathResut[2]);
                System.out.println(String.format("%s - %s = %d",mathResut[0],mathResut[2],min));
                break;
            case "*" :
                int x = Integer.parseInt(mathResut[0]) * Integer.parseInt(mathResut[2]);
                System.out.println(String.format("%s * %s = %d",mathResut[0],mathResut[2],x));
                break;
        }
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

