package com.codefun.concurrent;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Feb extends RecursiveTask<Integer> {

    volatile  int number = 0;


    public Feb(int num){
        number = num;
    }

    int seqFeb(int i){
        if(i<3){
            return 1;
        }
        return seqFeb(i-2)+seqFeb(i-1);
    }

    @Override
    protected Integer compute() {
        if(number < 13){
            return seqFeb(number);
        }
        Feb  left = new Feb(number-2);
        Feb  right = new Feb(number -1);
        left.fork();
        right.fork();

        number = left.join()+right.join();

        return number;
    }


    public static void main(String[] args) {


        Feb d = new Feb(100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
        Future<Integer> result = forkJoinPool.submit(d);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
