package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
‘,’=44, ‘s’=115, ‘t’=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

    FileInputStream fileInputStream = new FileInputStream(args[0]);

    byte[] fileData = new byte[fileInputStream.available()];

    while (fileInputStream.available()>0){
        fileInputStream.read(fileData);
        }

        fileInputStream.close();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        for (byte byteData : fileData) {
            char tmp = (char)byteData;
            if (!treeMap.containsKey(tmp)) treeMap.put(tmp, 1);
            else treeMap.put(tmp, treeMap.get(tmp) + 1);
        }

        for (Map.Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
