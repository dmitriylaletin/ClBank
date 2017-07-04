package com.javarush.task.task18.task1818;

/* 
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = bufferedReader.readLine();
        String secondFile = bufferedReader.readLine();
        String thirdFile = bufferedReader.readLine();

        FileOutputStream firstFileOutputStream = new FileOutputStream(firstFile);
        FileInputStream secondFileInputStream = new FileInputStream(secondFile);
        FileInputStream thirdFileInputStream = new FileInputStream(thirdFile);

        while (secondFileInputStream.available()>0){
            int data = secondFileInputStream.read();
            firstFileOutputStream.write(data);
        }

        while (thirdFileInputStream.available()>0){
            int data = thirdFileInputStream.read();
            firstFileOutputStream.write(data);
        }

        firstFileOutputStream.close();
        secondFileInputStream.close();
        thirdFileInputStream.close();
    }
}
