package com.example.ubuntu.testhttpclient;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zgjxf on 2018/1/9.
 */

public class TestTimeTask {

    @org.junit.Test
    public void testTime() {


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                // Toast.makeText(ReaderDemo.this, count+"", 500).show();
                if (count == 20) {
                    System.out.println("xxxx" + count);
                }else{
                    System.out.println("xxxxxxxxxx="+count);
                }
            }
        };


        timer.schedule(task, 1000, 1000);//第一次执行前的毫秒延迟时间。在随后的执行之间毫秒内的时间

    }
}
