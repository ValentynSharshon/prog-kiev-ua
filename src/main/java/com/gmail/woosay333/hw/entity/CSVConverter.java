package com.gmail.woosay333.hw.entity;

public interface CSVConverter {

    String toCSVString();

    Student fromCSVString(String str);

}
