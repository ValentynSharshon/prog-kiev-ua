package com.gmail.woosay333.files;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

    private final String[] array;

    public MyFileFilter(String... str) {
        this.array = str;
    }

    private boolean check(String ext) {
        for (String stringExt : array) {
            if (stringExt.equals(ext)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean accept(File pathname) {
        int pointIndex = pathname.getName().lastIndexOf(".");

        if (pointIndex == -1) {
            return false;
        }

        String ext = pathname.getName().substring(pointIndex + 1);
        return check(ext);
    }

}
