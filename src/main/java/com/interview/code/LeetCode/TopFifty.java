package com.interview.code.LeetCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

//多线程读取，失败一行直接跳过
public class TopFifty {

    private static int[] result = new int[50];
    private static Executor executor = Executors.newFixedThreadPool(5);
    private static volatile AtomicInteger size = new AtomicInteger(0);

    public int[] getTop(File[] files) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ReentrantLock lock = new ReentrantLock();
        for (File file : files){
            Processor processor = new Processor(file, countDownLatch,lock);
            executor.execute(processor);
        }
        countDownLatch.await();
        if (size.get() < 50){
            for(int num : result){
                adjustHeap(result[num]);
            }
        }
        return result;
    }

    //文件读取处理
    public class Processor implements Runnable{
        private File file;
        private CountDownLatch countDownLatch;
        private ReentrantLock lock;
        public Processor(File f, CountDownLatch latch, ReentrantLock reentrantLock){
            file = f;
            countDownLatch = latch;
            lock = reentrantLock;
        }
        @Override
        public void run() {
            try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    //流式处理
                    try {
                        int i = Integer.parseInt(line);
                        lock.lock();
                        if (size.get() <= 50) {
                            result[size.get()] = i;
                            size.incrementAndGet();
                        }
                        if (i <= result[0]) {
                            continue;
                        }
                        adjustHeap(i);
                        lock.unlock();
                    } catch (NumberFormatException e) {
                        //字符错误，跳过继续
                        continue;
                    }catch (Exception e){
                        //异常
                    }finally {
                        try {
                            lock.unlock();
                        } catch (Exception e) {
                            System.out.println("lock has already unlock");
                        }
                    }
                }
                countDownLatch.countDown();
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
    }
    //调整小顶堆
    private static void adjustHeap(int i) {
        // 获取左右节点数组下标
        int l = ((i + 1) << 1) - 1;
        int r = (i + 1) << 1;

        int smallest = i;

        if (l < result.length && result[l] < result[i]) {
            smallest = l;
        }

        if (r < result.length && result[r] < result[i]) {
            smallest = r;
        }

        if (i == smallest) {
            return;
        }
        swap(i, smallest);
        adjustHeap(smallest);
    }

    private static void swap(int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

}
