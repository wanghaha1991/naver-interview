package com.interview.code.P2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static HashMap<Object, Object> cacheData = new HashMap<>();

    public static void processCachedData(Object key, Object value) {
        try {
            lock.readLock().lock();
            if (isVaild(cacheData.get(key))) {
                //donothing
            }
            //update value
            lock.readLock().unlock();
            lock.writeLock().lock();
            try {
                if (!isVaild(cacheData.get(key))) {
                    cacheData.remove(key);
                    cacheData.put(key, value);
                }
                //downgrading
                lock.readLock().lock();

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    //todo
    public static boolean isVaild(Object object){
        return true;
    }

}
