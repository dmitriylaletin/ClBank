package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.
*/

public class Solution {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String fileName = bufferedReader.readLine();
            if (fileName.equals("exit"))
                break;
            else
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                HashMap<Integer, Integer> byteMap = new HashMap<>();
                int max = 0;
                int maxByte = 0;

                while (fileInputStream.available()>0){
                    int data = fileInputStream.read();
                   if (byteMap.containsKey(data)){
                       byteMap.put(data, byteMap.get(data)+1);
                   }
                   else byteMap.put(data, 1);
                   }

                fileInputStream.close();

               for(Map.Entry<Integer, Integer> pair: byteMap.entrySet()){
                  if (pair.getValue() > max){
                      max = pair.getValue();
                      maxByte = pair.getKey();
                  }
               }

               synchronized(resultMap) {resultMap.put(fileName, maxByte);}

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
