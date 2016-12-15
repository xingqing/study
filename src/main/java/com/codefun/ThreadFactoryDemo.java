package com.codefun;

import java.util.concurrent.ThreadFactory;

/** 
 * 
 * @author ���� :		E-mail: 
 * @version ����ʱ�䣺2016-7-29 ����1:33:27 
 * 
 */

public class ThreadFactoryDemo implements ThreadFactory {

	private static int index = 0;
	@Override
	public Thread newThread(Runnable r) {
		Thread thread =  new Thread(r);
		thread.setName("MyThread-"+(index++));
		return  thread;
	}

}
