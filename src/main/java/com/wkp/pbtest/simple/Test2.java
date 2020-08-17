package simple;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {

    @Test
    public void testSerilize() throws IOException {

        Person.Builder builder = Person.newBuilder();
        builder.setName("xiaoshan");
        builder.setAge(20);
        builder.setEmail("xxxxxxs@163.com");

        Person person = builder.build();

        byte[] byteArray = person.toByteArray();

        FileOutputStream outstream = new FileOutputStream(new File("Person.txt"));

        outstream.write(byteArray);
        outstream.close();
    }


    @Test
    public void testDeserialize() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("Person.txt"));

        Person person = Person.parseFrom(inputStream);
        inputStream.close();
        assertEquals(person.getName(), "xiaoshan");
        assertEquals(person.getAge(), 20);
        //旧proto文件里面没有新加的email字段，所以生成的java代码里面也没有
    }
}
