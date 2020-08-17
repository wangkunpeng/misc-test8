package com.wkp.pbtest.simple;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

//    @Test
//    public void testSerilize() throws IOException {
//
//        PersonMsg.Person.Builder builder = PersonMsg.Person.newBuilder();
//        builder.setName("xiaoshan");
//        builder.setAge(20);
//        //builder.setEmail("xxxxxxs@163.com");
//
//        PersonMsg.Person person = builder.build();
//
//        byte[] byteArray = person.toByteArray();
//
//        FileOutputStream outstream = new FileOutputStream(new File("/Users/wangkunpeng/Work/4study/misc-test8/src/main/java/com/wkp/pbtest/simple/Person"));
//
//        outstream.write(byteArray);
//        outstream.close();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    @Test
    public void testDeserialize() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("/Users/wangkunpeng/Work/4study/misc-test8/src/main/java/com/wkp/pbtest/simple/Person"));

        PersonMsg.Person person = PersonMsg.Person.parseFrom(inputStream);
        inputStream.close();

        System.out.println("getName -->" + person.getName());
        System.out.println("getAge -->" + person.getAge());

        //assertEquals(person.getName(), "xiaoshan");
        //assertEquals(person.getAgeccc(), 20);

        //System.out.println(person.getAgeccc());

    }
}