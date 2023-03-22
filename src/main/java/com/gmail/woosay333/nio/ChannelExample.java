package com.gmail.woosay333.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.lang.System.out;

public class ChannelExample {
    public static void main(String[] args) {
        String from = "E:\\Dow\\Windows\\ru windows xp professional with sp 3 x86 cd vl x14-74146.iso";
        String to = "copy.iso";

        //copyFile(from, to);
        //transferDemo(from, to);
        readLinesFromFile(".gitignore");
    }

    public static void readLinesFromFile(String filePath) {
        Path path = Path.of(filePath);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void transferDemo(String from, String to) {
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {

            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFile(String from, String to) {
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {

            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            ByteBuffer inBuffer = ByteBuffer.allocate(4096);
            ByteBuffer outBuffer = ByteBuffer.allocate(4096);

            int read = inputChannel.read(inBuffer);

            while (read != -1) {
                inBuffer.flip();

                while (inBuffer.hasRemaining()) {
                    byte get = inBuffer.get();
                    outBuffer.put(get);
                }

                outBuffer.flip();
                outputChannel.write(outBuffer);

                inBuffer.clear();
                outBuffer.clear();

                read = inputChannel.read(inBuffer);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
