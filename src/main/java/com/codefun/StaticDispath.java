package com.codefun;


/** 
 * 
 * @author 作者 :		E-mail: 
 * @version 创建时间：2016-8-12 上午9:47:19 
 * 
 */

public class StaticDispath {
		public class Person{};
		public class Man extends Person {};
		public class Woman extends Person {};
		public void sayHi(Person obj){
			System.out.println("Hi,Person");
		}
		public void sayHi(Man obj){
			System.out.println("Hi,Man");
		}
		public void sayHi(Woman obj){
			System.out.println("Hi,Woman");
		}
		public static void main(String[] args) {
			StaticDispath dispath  = new StaticDispath();
			Person  man = dispath.new Man();
			Person woman = dispath.new Woman();
			dispath.sayHi(man);
			dispath.sayHi(woman);
		}	
}
