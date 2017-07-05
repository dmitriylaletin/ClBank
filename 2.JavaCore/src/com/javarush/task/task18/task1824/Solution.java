package com.javarush.task.task18.task1824;

/* 
Файлы и исключения

Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        FileInputStream fileInputStream = null;

        while (true) {

            fileName = bufferedReader.readLine();

            try{
                fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();

            } catch (FileNotFoundException e){
                System.out.println(fileName);
                bufferedReader.close();
                break;
            }
        }
    }
}