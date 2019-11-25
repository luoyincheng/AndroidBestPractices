package yincheng.tinytank.java.randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("我的世界.txt", "rw");
			for (int i = 0; i < 10; i++) {
				randomAccessFile.writeDouble(i * Math.PI);//写入double类型的基本数据
			}
			randomAccessFile.close();
			randomAccessFile = new RandomAccessFile("我的世界.txt", "rw");
			//寻址，到第五个double数据结尾
			randomAccessFile.seek(5 * 8);
			//覆盖第六个double数据
			randomAccessFile.writeDouble(47.00001);
			randomAccessFile.close();
			randomAccessFile = new RandomAccessFile("我的世界.txt", "r");
			for (int i = 0; i < 10; i++) {
				System.out.println(String.valueOf(randomAccessFile.readDouble()));
			}
			randomAccessFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
