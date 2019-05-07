package cn.xiaozhigang.code.Basic.IODemo.NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFromFile {
    public static void main(String[] args) throws IOException{
        FileInputStream fin = new FileInputStream("D://test_buffered_reader.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        char c = buffer.getChar();
        System.out.println((int)c);
    }
}
