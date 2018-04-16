package com.javarush.task.task19.task1920;

/* 
Самый богатый
Петров 1.5
Иванов 1.35
Иванов -1.0
Петров -0.85
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        Double maxvalue = 0.0;
        Map<String, Double> resultMap = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                String input = bufferedReader.readLine();
                String name = input.split(" ")[0];
                Double sallary = Double.parseDouble(input.split(" ")[1]);
                if (!resultMap.containsKey(name)) {
                    resultMap.put(name,sallary);
                } else {
                    Double tempSalary = resultMap.get(name) + sallary;
                    resultMap.put(name, tempSalary);}
            }

            for (Map.Entry<String,Double> stringDoubleEntry : resultMap.entrySet()) {
                if (stringDoubleEntry.getValue() > maxvalue) maxvalue = stringDoubleEntry.getValue();
            }

            for (Map.Entry<String,Double> stringDoubleEntry : resultMap.entrySet()) {
            if (stringDoubleEntry.getValue().equals(maxvalue)) System.out.print(stringDoubleEntry.getKey()+" ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
