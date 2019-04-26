package com.codefun;

import java.util.concurrent.TimeUnit;


/** 
 * 
 * @author 作者 :		E-mail: 
 * @version 创建时间：2016-11-29 上午9:48:07 
 * 
 */

public class SingleObjTest {

	
	public static void main(String[] args) {
		Thread [] ts = new Thread[1000];
		
		for(int i = 0;i<ts.length;i++){
			ts[i] = new Thread(new SORunable());
		}
		
		for(int i = 0;i<ts.length;i++){
			ts[i].start();
		}
		
		while(Thread.activeCount()>1){
			Thread.yield();
		}
		
		System.out.println(SORunable.i);
	
	}
		
	static class SORunable implements Runnable{
		public static  volatile  int i =0;
		@Override
		public void run() {
			try {
				for(int i = 0;i<10;i++){
					SORunable.i = SORunable.i+1;
						TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
