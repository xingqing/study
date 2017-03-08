package com.codefun;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * @author 作者 : E-mail:
 * @version 创建时间：2016-8-1 下午3:23:32
 * 
 */

public class ChannelDemo {

	public static void main(String[] args) {
		RandomAccessFile aFile = null;
		try {
			aFile= new RandomAccessFile("C:\\set.txt",
					"rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer buf = ByteBuffer.allocate(4);
			System.out.printf("position:%s limit:%s capacity:%s \n",buf.position(),buf.limit(),buf.capacity());
			int bytesRead = -1;
			while ((bytesRead= inChannel.read(buf)) != -1) {
				System.out.printf("position:%s limit:%s capacity:%s \n",buf.position(),buf.limit(),buf.capacity());

				System.out.println("Read " + bytesRead);
				buf.flip();
				System.out.printf("position:%s limit:%s capacity:%s \n",buf.position(),buf.limit(),buf.capacity());
				while (buf.hasRemaining()) {
					System.out.println((char) buf.get());
				}
				System.out.printf("position:%s limit:%s capacity:%s \n",buf.position(),buf.limit(),buf.capacity());
				buf.clear();
				System.out.printf("position:%s limit:%s capacity:%s \n",buf.position(),buf.limit(),buf.capacity());
			}
			buf.clear();
			buf.put(new byte[]{97,98,99,100});
			buf.position(2);
			buf.limit(4);
		
			ByteBuffer buf2 = buf.slice();
			buf2.asReadOnlyBuffer();
			System.out.printf("position:%s limit:%s capacity:%s \n",buf2.position(),buf2.limit(),buf2.capacity());
			buf2.position(2);
			buf2.limit(2);
			
			System.out.printf("position:%s limit:%s capacity:%s \n",buf2.position(),buf2.limit(),buf2.capacity());
			buf2.flip();
			System.out.printf("position:%s limit:%s capacity:%s \n",buf2.position(),buf2.limit(),buf2.capacity());
			inChannel.write(buf2);
			System.out.printf("position:%s limit:%s capacity:%s \n",buf2.position(),buf2.limit(),buf2.capacity());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				aFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
