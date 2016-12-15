package com.codefun;


/** 
 * 
 * @author 作者 :		E-mail: 
 * @version 创建时间：2016-11-29 上午9:43:49 
 * 
 */

public class SingleObj {
	
	private static  SingleObj instance = null;
	public static int i = 0;
	private SingleObj(){
		System.out.println("实例化SingleObj");
	
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
