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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].equals("-c")) return;
        
        float price;
        int quantity;
        
        try {
            price = Float.parseFloat(args[2]);
            quantity = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            return;
        }
            String productName = args[1];
        
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (fileReader.ready())
                lines.add(fileReader.readLine());
        }
        
        int maxID = 0;
        for (String s : lines) {
        String[] datas = s.split(" ");
        int currentId = Integer.valueOf(datas[0]);
        maxID = (maxID > currentId) ? maxID : currentId;
        }
        
        String productString = String.format("%1$-8.8s %2$-30.30s %3$-8.8s %4$-4.4s", maxID+1, productName, price, quantity);
        
        lines.add(productString);
        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (String s: lines)
                buf.write(s+"\r\n");
        }
    }
}

