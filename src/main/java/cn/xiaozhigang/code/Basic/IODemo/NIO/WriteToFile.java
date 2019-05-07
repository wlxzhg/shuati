package cn.xiaozhigang.code.Basic.IODemo.NIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class WriteToFile {
    public static void main(String[] args) throws IOException{
        FileOutputStream fout = new FileOutputStream("D://nio_write_to_file.txt",true);
        FileChannel fc = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        byte[] mssage = "你好，世界\n".getBytes();

        for(int i = 0; i < mssage.length; i++) {
            buffer.put(mssage[i]);
        }
        buffer.flip();

        fc.write(buffer);

        System.out.println(Charset.defaultCharset().name());
    }
}
