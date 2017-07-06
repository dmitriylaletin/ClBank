package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) {

        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileInStream = null;
        FileOutputStream fileOutStream = null;


            try {
                fileInStream = new FileInputStream(fileName);
                fileOutStream = new FileOutputStream(fileOutputName);

                byte[] data = new byte[fileInStream.available()];
                while (fileInStream.available()>0){

                    int count = fileInStream.read(data);

                    if (key.equals("-e")){data = encryption(data);}

                    if (key.equals("-d")){data = decryption(data);}

                    fileOutStream.write(data, 0, count);
                }

                fileInStream.close();
                fileOutStream.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }


    public static byte[] encryption(byte[] data) {
        for (int i = 0; i < data.length ; i++) {
            int x = (int) data[i];
            x = (~x);
            data[i] =(byte)x;
        }
        return data;
    }




    public static byte[] decryption(byte[] data) {
        for (int i = 0; i < data.length ; i++) {
            int x = (int) data[i];
            x = (~x);
            data[i] =(byte)x;
        }
        return data;
    }


}