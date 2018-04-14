package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(File fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }


    public void write (char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf,off,len);

        System.out.print(String.valueOf(cbuf,off,len));
    }

    public void write (int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off+len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(String.copyValueOf(cbuf));
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\DevInfo\\File2.txt";
        String test ="Dima very great dev";

        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(filePath);
        fileConsoleWriter.write(12);
        fileConsoleWriter.write(test, 1,6);

    }

}
