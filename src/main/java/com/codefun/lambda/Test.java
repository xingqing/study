package com.codefun.lambda;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by Administrator on 2017/4/17.
 */
public class Test {


    public static void main(String[] args) {

        String  msg = "abcdefg";
        String[] strings = msg.split("");

        Stream.of(strings).forEach(System.out::println);
        Stream.of(strings).forEach(s->{System.out.println(s);});

        String aaa = Stream.of(strings).sorted(comparing(String::toString).reversed()).reduce((a,b)->a+b).get();

        System.out.println(aaa);

        UnaryOperator<String> c = (String s) -> s+"done";
        try {
            System.out.println(c.apply("abc"));
        }catch (Exception e){
            e.printStackTrace();
        }


        new Thread(()-> System.out.println("abc")).start();




    }

}
