package com.FileNotFoundException;
import java.io.*;
public class FileException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			File newFile = new File("Demo.txt");
			FileReader fr = new FileReader(newFile);
		} catch(FileNotFoundException e) {
			System.out.println("Exception Handled");
			e.printStackTrace();
		}
		
	}

}
