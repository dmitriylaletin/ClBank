package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = bufferedReader.readLine();
        String secondFile = bufferedReader.readLine();


        FileInputStream firstFileInputStream= new FileInputStream(firstFile);
        byte[] firstFileDataArray = new byte[firstFileInputStream.available()];

        while (firstFileInputStream.available()>0){
            firstFileInputStream.read(firstFileDataArray);
        }
        firstFileInputStream.close();

        FileOutputStream firstFileOutputStream = new FileOutputStream(firstFile);
        FileInputStream secondFileInputStream = new FileInputStream(secondFile);

        while (secondFileInputStream.available()>0){
            int byteData = secondFileInputStream.read();
            firstFileOutputStream.write(byteData);
        }

        secondFileInputStream.close();
        firstFileOutputStream = new FileOutputStream(firstFile, true);

        for (byte b :firstFileDataArray) {
            firstFileOutputStream.write(b);
        }

        firstFileOutputStream.close();

    }
}
