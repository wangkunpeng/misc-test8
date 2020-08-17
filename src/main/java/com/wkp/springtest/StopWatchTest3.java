package com.wkp.springtest;

import com.wkp.gsontest.Student;
import org.springframework.util.StopWatch;

import java.util.Collections;
import java.util.List;

public class StopWatchTest3 {
    private void test() throws InterruptedException {
        List list = Collections.emptyList();
        //list.add(124);
    }

    public static void main(String[] argv) throws InterruptedException, ClassNotFoundException {
        StopWatchTest3 testStopWatch = new StopWatchTest3();
        testStopWatch.test();

        Class clazz = Class.forName("com.wkp.gsontest.Student$Student1");
        System.out.println(clazz.toString());
        //class clazz =Student.Student1.class;
    }
}
