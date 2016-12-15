package com.codefun;
/** 
 * 
 * @author 作者 :		E-mail: 
 * @version 创建时间：2016-7-28 下午3:34:59 
 * 
 */

public class ThreadTest {
	private static  int flag = 0;
	private static int count = 0;
	public static synchronized void setFlag(int value){
		flag = value;
		count++;
		if(count==100){
			System.out.println("开始输出");
			ThreadTest.class.notifyAll();
		}else{
			try {
				ThreadTest.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static class MyRunnable implements Runnable{
		private int val = 0;
		public MyRunnable(int val){
			this.val = val;
		}
		@Override
		public void run() {
				setFlag(val);
				System.out.printf("%s:%s\n",val,Thread.currentThread().getPriority());			
		}
		
	}
	
	public static void main(String[] args) {
		
		Thread [] runs = new Thread[100];
		int [] prioritys = new int[]{Thread.MAX_PRIORITY,Thread.NORM_PRIORITY,Thread.MIN_PRIORITY}; 
		
		for(int i = 0;i<runs.length;i++){
			runs[i]=new Thread(new ThreadTest.MyRunnable(i));
			runs[i].setPriority(prioritys[(int)Math.floor(Math.random()*3)]);
		}
		for(Thread run : runs){
			run.start();
		}
		
		for(Thread run : runs){
			try {
				run.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("完成");
		
		
	}
	
	
	

}
