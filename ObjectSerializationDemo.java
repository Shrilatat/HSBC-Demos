package com.trg.fileio;

import java.io.*;

public class ObjectSerializationDemo {
	public static void main(String args[]) {
		try {
			Student s1 = new Student(100, "Varsha");
			Student s2 = new Student(101, "Soha");
			System.out.println("s1 object : " + s1);

			FileOutputStream fos = new FileOutputStream("student.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.flush();
			oos.close();
		} catch (Exception e) {
		}

		try {
			Student s3, s4;
			FileInputStream fis = new FileInputStream("student.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			s3 = (Student) ois.readObject();
			s4 = (Student) ois.readObject();
			ois.close();
			System.out.println("s3 object : " + s3);
			System.out.println("s4 object : " + s4);
		} catch (Exception e) {
		}
	}
}
