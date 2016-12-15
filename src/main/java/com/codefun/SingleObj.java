package com.codefun;


/** 
 * 
 * @author ���� :		E-mail: 
 * @version ����ʱ�䣺2016-11-29 ����9:43:49 
 * 
 */

public class SingleObj {
	
	private static  SingleObj instance = null;
	public static int i = 0;
	private SingleObj(){
		System.out.println("ʵ����SingleObj");
	
	}
	
	public static SingleObj getInstance(){
		if(null == instance){
			synchronized (SingleObj.class) {
				if(null == instance){
					instance = new SingleObj();
				}
			}
		}
		return instance;
	}
}
