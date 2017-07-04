package com.javarush.task.task18.task1817;

/* 
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        double spaceCounter = 0;
        double allCharsCounter = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available()>0){
            allCharsCounter++;
            char data = (char) fileInputStream.read();
            if (data == ' ') spaceCounter++;
        }

        fileInputStream.close();
        double result =  (spaceCounter / allCharsCounter * 100);
        System.out.println(String.format("%.2f", result));
    }
}
