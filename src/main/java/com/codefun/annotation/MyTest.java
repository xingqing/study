package com.codefun.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/2/6.
 */
@MyAnnotation(hello = "beijing", world="shanghai",array={},style=int.class)
public class MyTest
{
    @MyAnnotation(world = "shanghai",array={1,2,3})
    @Deprecated
    @SuppressWarnings("")
    public void output()
    {
        System.out.println("output something!");
    }
}

class MyReflection
{
    public static void main(String[] args) throws Exception
    {
        MyTest myTest = new MyTest();
        Class<MyTest> c = MyTest.class;
        Method method = c.getMethod("output", new Class[] {});
        //���MyTest��������ע��@MyAnnotation���Σ���Ϊtrue
        if(MyTest.class.isAnnotationPresent(MyAnnotation.class))
        {
            System.out.println("have annotation");
        }
        if (method.isAnnotationPresent(MyAnnotation.class))
        {
            method.invoke(myTest, null); //����output����
            //��ȡ������ע��@MyAnnotation����Ϣ
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String hello = myAnnotation.hello();
            String world = myAnnotation.world();
            System.out.println(hello + ", " + world);//��ӡ����hello��world��ֵ
            System.out.println(myAnnotation.array().length);//��ӡ����array����ĳ���
            System.out.println(myAnnotation.style());
        }
        //�õ�output�����ϵ�����ע�⣬��Ȼ�Ǳ�RetentionPolicy.RUNTIME���ε�
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations)
        {
            System.out.println(annotation.annotationType().getName());
        }
    }
}