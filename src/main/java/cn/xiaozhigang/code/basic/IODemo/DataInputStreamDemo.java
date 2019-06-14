package cn.xiaozhigang.code.basic.IODemo;

import java.io.*;

public class DataInputStreamDemo {
    public static void main(String[] args) throws Exception {
//        testDataInputStream();
        testDataInputStream2();

    }

    /**
     * DataOutputStream和DataInputStream测试2
     * 使用DataOutputStream输出1到100数字到文件。
     * 使用DataInputStream从文件中读取数字
     * */
    private static void testDataInputStream2() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D://test.dat"));
        for(int i = 0; i < 100; i++)
            dos.writeInt(i);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("D://test.dat"));
        for(int i = 0; i < 100; i++)
            System.out.println(dis.readInt());
        dis.close();
    }

    /**
     * 测试DataInputStream和DataOutputStream
     * DataOutputStream用于二进制格式输出，特点是可以输出基本数据类型。
     * DataInputStream二进制格式读入，可以还原输出的基本类型
     * */
    private static void testDataInputStream() throws IOException {
        //这里使用了
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D://text.dat"));

        dos.writeBoolean(true);
        dos.writeInt(100);
        dos.writeDouble(3.14159);

        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("D://text.dat"));
        boolean f = dis.readBoolean();
        int a = dis.readInt();
        double d = dis.readDouble();

        System.out.println(f + "\t" + a + "\t" +  d);
        dis.close();
    }
}
