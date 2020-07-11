package com.wkp.springtest;

import org.springframework.util.StopWatch;

public class StopWatchTest2 {
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
        StopWatchTest2 testStopWatch = new StopWatchTest2();
        testStopWatch.test();
        //u1
        //u10
        //u0
        //u2
        //u3
        //u5
        //u4
        //u6
        //u7
        //u11
	//u12
	//u13
	//u14
	//u15
	//u16
	//u17
	//u18
	//u19
        //uu22
    }
}
