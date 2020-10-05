package com.trg.fileio;

import java.io.*;
import java.util.Date;

class Student implements Serializable {
	int roll;
	String sname;
	 //transient Date today = new Date();

	public Student(int r, String s) {
		roll = r;
		sname = s;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", sname=" + sname + "]";
	}
	
}