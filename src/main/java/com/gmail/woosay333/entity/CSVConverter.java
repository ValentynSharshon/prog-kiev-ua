package com.gmail.woosay333.entity;

public interface CSVConverter {

    String toCSVString();

    Student fromCSVString(String str);

}
