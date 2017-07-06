package com.javarush.task.task18.task1827;

/* 
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846    Шорты пляжные синие           159.00 12
198478   Шорты пляжные черные с рисунко173.00 17
19847983 Куртка для сноубордистов, разм10173.991234


*/


import java.io.*;
import java.nio.file.Files;

public class Solution {

    public static void main(String[] args) throws Exception {
       BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
       File fileName = new File(fileNameReader.readLine());
       fileNameReader.close();

       if (args.length != 0){
           String id = idGenerator(fileName);
           String description = args[1];
           String price = args[2];
           String quantity = args[3];
           String productString = String.format("%1$-8.8s %2$-30.30s %3$-8.8s %4$-4.4s", id, description, price, quantity);
           addToBase(fileName, productString);
       }
    }

    public static String idGenerator(File fileName){
        int id = 0;
        String idString;
        BufferedReader bufferedReader = null;
        if (fileName.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(fileName));
                while ((idString = bufferedReader.readLine()) != null) {
                    String[] datas = idString.split(" ");
                    idString = datas[0];
                    int currentId = Integer.valueOf(idString);
                    id = (id > currentId) ? id : currentId;
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return String.valueOf(++id);
    }

    public static void addToBase(File fileName, String dataString){
        try {

            if(!fileName.exists()){
                fileName.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.write( dataString + "\n");
            bufferedWriter.close();

        }catch (IOException e){
            e.printStackTrace();}

    }
}
