package com.codefun;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/** 
 * 
 * @author ���� :		E-mail: 
 * @version ����ʱ�䣺2016-8-1 ����9:44:39 
 * 
 */

public class SemaphoreDemo {
	
	
	public static void main(String[] args) {
		
		PrintJob print = new PrintJob(false);
		MyJob job = new MyJob(print);
		
		ThreadFactoryDemo factory = new ThreadFactoryDemo();
		Thread [] threads = new Thread[10];
		for(int i=0;i<10;i++){
			threads[i]= factory.newThread(job);
		}
		for(Thread t : threads){
			t.start();
		}
		
		
		
	}
	
	
	
	
	public static class PrintJob{
		
		private boolean timeFrist = false;
		public PrintJob(boolean timeFrist){
			this.timeFrist = timeFrist;
			pv= new Semaphore(1,this.timeFrist);
		}
		
		private Semaphore pv = null;
		
		private void print(){
			String name = Thread.currentThread().getName();
			System.out.printf("%s�����ӡԤ������\n",name);
			try{
				pv.acquire();
				System.out.printf("%s��ӡ:%s\n",name,new Random().nextInt(200));
				TimeUnit.SECONDS.sleep(2);
				System.out.printf("%s���,�ͷŴ�ӡ��\n",name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				pv.release();
			}
			
		}
		
	}
	
	public static class MyJob implements Runnable{
		
		private PrintJob print;
		
		public MyJob(PrintJob print){
			this.print = print;
		}

		@Override
		public void run() {
			this.print.print();
		}
		
		
	}
	
	
	

}
