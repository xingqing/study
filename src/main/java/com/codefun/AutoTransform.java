package com.codefun;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/** 
 * 
 * @author 作者 :		E-mail: 
 * @version 创建时间：2016-8-12 下午1:57:19 
 * 
 */

public class AutoTransform {
	
	public void print(char c){
		System.out.println(String.format("char:%s",c));
	}
	public void print(int i){
		System.out.println(String.format("int:%s",i));
	}
	public void print(char... chars ){
		System.out.println(String.format("chars:%s", chars.length));
	}
	public void print(double i){
		System.out.println(String.format("double:%s",i));
	}
	public void print(float i){
		System.out.println(String.format("float:%s",i));
	}
	public void print(Character cc){
		System.out.println(String.format("Character:%s",cc));
	}
	public void print(Serializable ser){
		System.out.println(String.format("Serializable:%s",ser));
	}
	public void print(Comparable<Character>  comp){
		System.out.println(String.format("Comparable:%s",comp));
	}
	public void print(Object obj){
		System.out.println(String.format("Object:%s",obj));
	}
	public static void main(String[] args) {
		//new AutoTransform().print('a');
		Integer [] aaa = new Integer[]{1,2,3,4,5};
		int [] bbb = new int []{1,2,3,4,5};
		Object a = aaa;
		System.out.println(aaa.getClass().getComponentType().isPrimitive());
		System.out.println(bbb.getClass().getComponentType().isPrimitive());
		System.out.println(a.getClass().isPrimitive());
		Class<?> clazz = a.getClass().getComponentType();
		List<?> list = Arrays.asList(aaa);
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
		
		System.out.println(clazz.getName());
		
		
	}
	

}
