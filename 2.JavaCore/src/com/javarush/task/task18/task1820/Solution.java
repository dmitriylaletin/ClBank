package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = bufferedReader.readLine();
        String secondFile = bufferedReader.readLine();
        String outputData = "";

        FileInputStream firstFileInputStream = new FileInputStream(firstFile);
        FileOutputStream secondFileOutputStream = new FileOutputStream(secondFile);
        byte[] firstFileData = new byte[firstFileInputStream.available()];

        while (firstFileInputStream.available()>0){
            firstFileInputStream.read(firstFileData);
        }

        firstFileInputStream.close();

        String[] firstFileDataString = new String(firstFileData).split(" ");
        for (String s : firstFileDataString) {
            outputData+=(Math.round(Double.parseDouble(s)) + " ");
        }
        secondFileOutputStream.write(outputData.trim().getBytes());
        secondFileOutputStream.close();
    }
}
