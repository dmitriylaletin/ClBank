package com.javarush.task.task18.task1828;

/* 
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:

19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> fileStrings = new ArrayList<>();
        BufferedReader fileStringReader;
        BufferedWriter fileStringWriter;
        String checkedString;
        String id = args[1];

        fileStringReader = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(fileStringReader.readLine());

        fileStringReader = new BufferedReader(new FileReader(fileName));

        while ((checkedString = fileStringReader.readLine()) != null) {

            if ((checkedString.startsWith(id)) && (args[0].equals("-u"))){
                checkedString = String.format("%1$-8.8s %2$-30.30s %3$-8.8s %4$-4.4s",
                        args[1], args[2], args[3], args[4]);
            }

            if ((checkedString.startsWith(id)) && (args[0].equals("-d"))){
                continue;
            }

            fileStrings.add(checkedString);
        }
        fileStringReader.close();

        fileStringWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: fileStrings){
                fileStringWriter.write(s+"\r\n");
            }
            fileStringWriter.close();
        }
    }
