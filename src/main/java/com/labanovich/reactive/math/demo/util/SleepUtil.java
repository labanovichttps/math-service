package com.labanovich.reactive.math.demo.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SleepUtil {

    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
