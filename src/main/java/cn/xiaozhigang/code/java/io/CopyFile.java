package cn.xiaozhigang.code.java.io;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException{
        File source = new File("D:\\xiaozhigang\\source.txt");
        File dest = new File("D:\\xiaozhigang\\dest.txt");
        copyFileByStream(source,dest);
    }

    public static void copyFileByStream(File source, File dest) throws IOException {
//        try (InputStream is = new FileInputStream(source);
//             OutputStream os = new FileOutputStream(dest)){
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer)) > 0) {
//                os.write(buffer, 0, length);
//            }
//        }
    }
}
