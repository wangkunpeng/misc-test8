package com.wkp.springtest;

import org.springframework.util.StopWatch;

public class StopWatchTest {
    private void test() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start("起床");
        Thread.sleep(1000);
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();

        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
    }


    public static void main(String[] argv) throws InterruptedException {
        StopWatchTest testStopWatch = new StopWatchTest();
        testStopWatch.test();
	//u0
	//u2
    }
}
