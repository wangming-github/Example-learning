package com.wangming.algorithm.io;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * 对象的序列化机制   java对象通过流的形式转化为二进制流 然后存储在硬盘文件中
 * 对象的序列反化机制  二进制流还原为java对象
 */
public class IO_Day6_Stream_3_ObjectStream {

    //1.此类可序列化（实现Serializable  静态的内部类才可以被序列化）
    //2.类的属性也需要实现序列化
    //3.对象流不能序列化 static声明的属性
    public static class Book implements Serializable {
        //不能 static 声明
        String name;
        String author;

        Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        public Book() {
        }

        public String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }

    }

    //对象序列化 保存到 文件中
    @Test
    public void serializable() {

        String fileName = "07.IO_Day6_Stream_3_ObjectStream.txt";
        Book book = new Book("《挪威的森林》", "村上春树");
        Book book_2 = new Book("《红楼梦》", "曹雪芹");

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(book);
            objectOutputStream.flush();
            objectOutputStream.writeObject(book_2);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //对象序列化 保存到 文件中
    @Test
    public void unserializable() {

        String fileName = "07.IO_Day6_Stream_3_ObjectStream.txt";
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Book book1 = (Book) objectInputStream.readObject();
            Book book2 = (Book) objectInputStream.readObject();
            System.out.println(book1);
            System.out.println(book2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
