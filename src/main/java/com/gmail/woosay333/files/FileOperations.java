package com.gmail.woosay333.files;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class FileOperations {

    private FileOperations() {
    }

    public static void fileCopy(File in, File out) throws IOException {
        byte[] buffer = new byte[1024 * 1024 * 10];
        int readBytes = 0;

        try (FileInputStream fis = new FileInputStream(in);
             FileOutputStream fos = new FileOutputStream(out)) {
            while ((readBytes = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, readBytes);
            }
        }
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        } else {
            long folderSize = 0;
            File[] files = folder.listFiles();
            assert files != null;

            for (File file : files) {
                folderSize += getFolderSize(file);
            }

            return folderSize;
        }
    }

    public static void encodingDemo(String filePath) throws IOException {
        try (InputStream is = new FileInputStream(filePath);
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                out.println(line);
            }
        }
    }

}
