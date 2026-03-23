package com.telusko.learn.practise;

import java.lang.ref.Cleaner;

public class GarbageCollector {
   static Cleaner.Cleanable cleanable = Cleaner.create().register(new Object(), () -> System.out.println("ran successfully"));
    static void main() throws InterruptedException {
        GarbageCollector garbageCollector = new GarbageCollector();
        System.gc();
        Thread.sleep(1000);
    }
}
