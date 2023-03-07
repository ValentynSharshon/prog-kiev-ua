package com.gmail.woosay333.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {

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
}
