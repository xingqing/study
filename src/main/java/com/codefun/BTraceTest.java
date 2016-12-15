package com.codefun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BTraceTest {
	
	public String sayHi(String name,String msg){
		return name+":"+msg;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BTraceTest bTraceTest=new BTraceTest();
		String name= bReader.readLine();
		String msg = bReader.readLine();
		System.out.println(bTraceTest.sayHi(name, msg));
		bReader.readLine();
	}
}
