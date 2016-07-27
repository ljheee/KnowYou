package com.Joke.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.Document;
/**
 * �ռ�
 *
 */
public class Diary {

	public static void addDiary(String pathname, String title, String txt) {
		// pathname�����û����������ļ���
		File dirfile = new File(pathname);
		BufferedWriter bufw = null;
		// �����ļ���
		dirfile.mkdirs();

		// �����ռ��ļ�����׺Ϊ.kz
		File file = new File(dirfile, title + ".ky");
		try {
			// д���ļ�
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

		// ������ȡ������ȡ�ļ����ݣ�����������������ӵ��ռ���ʾ��
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(file));
			{
			}
			String txt = null;
			// ��ȡ���з�������������ǿ��ƽ̨��
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
