package cn.xiaozhigang.code.basic.IODemo.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void main(String[] args) throws IOException{
        String inFile = "D://test_buffered_reader.txt";
        String outFile = "D://test_buffered_reader1.txt";

        FileInputStream fin = new FileInputStream(inFile);
        FileOutputStream fout = new FileOutputStream(outFile);

        FileChannel finChannel = fin.getChannel();
        FileChannel foutChannel = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int r = finChannel.read(buffer);
            if(r == -1)
                break;
            buffer.flip();
            foutChannel.write(buffer);
        }
    }
}
