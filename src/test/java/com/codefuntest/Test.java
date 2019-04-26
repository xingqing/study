package com.codefuntest;


import org.ho.yaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		try(InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("test.yml")){
			HashMap<String,Object> map = Yaml.loadType(inputStream, HashMap.class);
			System.out.println(map);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
