package com.wangming.algorithm.io;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//java.io.File
//重要: 文件流 缓冲流
//次要: 对象流 随机存取文件流
//次要: 转换流 打印流 数据流 标准输入/输出流
public class IO_Day1_File {

    //1.IO包下；和输入输出有关。
    //2.File有构造器。此对象对应着一个文件或者一个文件目录
    //3.File对象与平台无关
    //4.File中的方法仅涉及到 创建 删除 命名 等
    //5.File类的对象通常作物IO流的具体类的构造器的形参。

    /**
     * 路径:
     * 绝对路径 包括盘符
     * 相对路径 当前文件目录下的路径
     */
    @Test
    public void test1() throws IOException {
        //绝对路径
        String path1 = "/Users/maixiao/Desktop/文档/SpringBoot-基于注解的加解密/java-example/hello_path_new.txt";
        //相对路径
        String path2 = "hello.txt";
        File file1 = new File(path1);
        File file2 = new File(path2);

        System.out.println("--------------访问文件名--------------");
        System.out.println("文件名    " + file1.getName());
        System.out.println("路径     " + file1.getPath());
        System.out.println("绝对路径名 " + file1.getAbsoluteFile());
        System.out.println("绝对路径名 " + file1.getAbsolutePath());
        System.out.println("上层目录  " + file1.getParent());
        // file1.renameTo(file1) 文件重命名:file1 file1都必须同为文件 ，亦或者文件目录，与是否为相对路径，绝对路径没关系。
        System.out.println("重命名    " + file1.renameTo(new File("hello_path_new.txt")));
    }

    @Test
    public void test2() throws IOException {
        //绝对路径
        String path1 = "/Users/maixiao/Desktop/文档/SpringBoot-基于注解的加解密/java-example/hello_path_new.txt";
        //相对路径
        String path2 = "hello.txt";
        File file1 = new File(path1);
        File file2 = new File(path2);

        System.out.println("--------------文件检测--------------");
        System.out.println("文件存在    " + file1.exists());
        System.out.println("文件能写入    " + file1.canWrite());
        System.out.println("文件能读取    " + file1.canRead());
        System.out.println("文件是文件    " + file1.isFile());
        System.out.println("文件是目录    " + file1.isDirectory());

        System.out.println("--------------文件信息--------------");
        System.out.println("文件最后修改时间    " + new Date(file1.lastModified()));
        System.out.println("文件字符长度    " + file1.length());
    }

    @Test
    public void test3() throws IOException {
        String path1 = "/Users/maixiao/Desktop/文档/SpringBoot-基于注解的加解密/java-example/hello_path_new.txt";
        String path2 = "/Users/maixiao/Desktop/文档/SpringBoot-基于注解的加解密/java-example/dir/dir1";
        String path3 = "/Users/maixiao/Desktop/文档/SpringBoot-基于注解的加解密/java-example/dir";
        String path4 = "/Users/maixiao/Desktop/文档";

        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);
        File file4 = new File(path4);

        System.out.println("--------------文件操作--------------");
        System.out.println("删除 " + file1.delete());
        if (!file1.exists()) {
            System.out.println("创建 " + file1.createNewFile());
        }

        System.out.println("--------------目录操作--------------");
        //mkdir 上层目录必须存在
        System.out.println("删除 " + file3.delete());
        if (!file3.exists()) {
            System.out.println("创建    " + file3.mkdir());
        }

        //mkdirs 上层目录一并创建
        System.out.println("删除 " + file2.delete());
        if (!file2.exists()) {
            System.out.println("创建    " + file2.mkdirs());
        }

        //只取出名字
        String[] list = file4.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println();
        //取出名字并且可以操作
        File[] files = file4.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }


    }
}
