package com.gmail.woosay333.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
    public static void main(String[] args) {
        String from = "E:\\Dow\\Windows\\ru windows xp professional with sp 3 x86 cd vl x14-74146.iso";
        String to = "copy.iso";

        copyFile(from, to);
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
