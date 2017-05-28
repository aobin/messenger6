package com.aobin.messenger.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by 敖斌 on 2017/5/28.
 */
@Service
public class AsyncService
{

    @Async
    public Future<String> getStringResponseInFuture()
    {
        System.out.println(Thread.currentThread().getName()+" start to execute!");
        try
        {
            Thread.sleep(5*1000);

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" execute finished!");
        return new AsyncResult<>(Thread.currentThread().getName());
    }

}
