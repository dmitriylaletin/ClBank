package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        String fileName = args[0];
        Map<String, Double> resultMap = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){

            while (bufferedReader.ready()){
                String input = bufferedReader.readLine();
                String name = input.split(" ")[0];
                Double sallary = Double.parseDouble(input.split(" ")[1]);
                if (!resultMap.containsKey(name)) {
                    resultMap.put(name,sallary);
                } else {
                    Double tempSalary = resultMap.get(name) + sallary;
                    resultMap.put(name, tempSalary);}
            }

            for (Map.Entry<String, Double> entrySet : resultMap.entrySet()) {
                System.out.println(entrySet.getKey()+" "+entrySet.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
