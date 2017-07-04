package com.javarush.task.task18.task1822;

/* 
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id — int.
productName — название товара, может содержать пробелы, String.
price — цена, double.
quantity — количество, int.

Информация по каждому товару хранится в отдельной строке.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();


        BufferedReader stringReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String check;
        String id = String.valueOf(Integer.parseInt(args[0]));
        while ((check = stringReader.readLine()) != null){
            if (check.startsWith(id)) System.out.println(check);
        }
        stringReader.close();
    }
}
