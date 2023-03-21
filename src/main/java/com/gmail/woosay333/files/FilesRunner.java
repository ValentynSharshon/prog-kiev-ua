package com.gmail.woosay333.files;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import static java.lang.System.out;

public class FilesRunner {

    public static void main(String[] args) throws IOException {
        FileFilter fileFilter = new MyFileFilter("mp3", "exe", "zip", "json");
        String path = "E:\\Dow";
        File folder = new File(path);
        File[] files = folder.listFiles(fileFilter);

        assert files != null;
        for (File file : files) {
            out.println(file);
        }

        long size = FileOperations.getFolderSize(folder);
        out.println(size);

        FileOperations.encodingDemo("C:\\Users\\Администратор\\Desktop\\нові паролі для ЕЦП ключів.txt");
    }

}
