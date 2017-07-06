package com.javarush.task.task18.task1825;

/* 
Собираем файл

Собираем файл из кусочков.

Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.



*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        String inFilename = null;
        String outFileName = null;
        String dir = null;
        BufferedReader fileNameReader = null;
        FileInputStream filesReader = null;
        FileOutputStream filesWriter = null;
        TreeMap<String, Integer> filesMap = new TreeMap<>();

// Getting sorted filenames in TreeMap
        try{
        fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = fileNameReader.readLine();
            if (fileName.equals("end")) break;
            inFilename = fileName;
            String[] indexSplitter = fileName.split("(?=\\d*$)", 2);
            int filePartIndex = Integer.valueOf(indexSplitter[1]);
            filesMap.put(fileName, filePartIndex);
        }
        fileNameReader.close();

// Preparing outsource file

        String tmp = inFilename.substring(inFilename.lastIndexOf("/") + 1, inFilename.length());
        String[] nameSplitter = tmp.split("\\.", 3);
        outFileName = nameSplitter[0] + "." + nameSplitter[1];
        dir = inFilename.substring(0, inFilename.lastIndexOf("/")+1);

        File outsourceFile = new File(dir+outFileName);
        outsourceFile.createNewFile();

        filesWriter = new FileOutputStream(outsourceFile, true);

// Writing outsource file

        for (Map.Entry<String, Integer> pair : filesMap.entrySet()) {
            filesReader = new FileInputStream(pair.getKey());
            byte[] filesData = new byte[filesReader.available()];
            while (filesReader.available() > 0) {
                int count = filesReader.read(filesData);
                filesWriter.write(filesData, 0, count);
            }
            filesReader.close();
        }
        filesWriter.close();
    } catch (Exception e){
            e.printStackTrace();
       } finally {
           fileNameReader.close();
           filesReader.close();
           filesWriter.close();
       }
    }
}
