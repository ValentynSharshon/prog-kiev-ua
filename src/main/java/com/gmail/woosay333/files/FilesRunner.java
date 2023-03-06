package com.gmail.woosay333.files;

import java.io.File;
import java.io.FileFilter;

import static java.lang.System.out;

public class FilesRunner {

    public static void main(String[] args) {
        FileFilter fileFilter = new MyFileFilter("mp3", "exe", "zip", "json");

        String path = "D:\\Downloads";
        File filder = new File(path);
        File[] files = filder.listFiles(fileFilter);

        for (File file : files) {
            out.println(file);
        }
    }

}
