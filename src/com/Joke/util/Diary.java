package com.Joke.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.Document;
/**
 * 日记
 *
 */
public class Diary {

	public static void addDiary(String pathname, String title, String txt) {
		// pathname是以用户名命名的文件夹
		File dirfile = new File(pathname);
		BufferedWriter bufw = null;
		// 建立文件夹
		dirfile.mkdirs();

		// 建立日记文件，后缀为.kz
		File file = new File(dirfile, title + ".ky");
		try {
			// 写入文件
			bufw = new BufferedWriter(new FileWriter(file, true));
			bufw.write(txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(File file, Document doc) {

		// 创建读取流，读取文件内容，并将读到的内容添加到日记显示区
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(file));
			{
			}
			String txt = null;
			// 获取换行符。这样可以增强跨平台性
			String line = System.getProperty("line.separator");
			while ((txt = bufr.readLine()) != null) {

				doc.insertString(doc.getLength(), txt + line, null);

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
