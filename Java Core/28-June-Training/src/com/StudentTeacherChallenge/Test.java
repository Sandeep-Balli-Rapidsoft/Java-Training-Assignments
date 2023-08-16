package com.StudentTeacherChallenge;

class Board {
	String text;
	int noOfStudents;
	int count = 0;
	void attendance() {
		noOfStudents++;
	}
	
	synchronized public void write(String str) {
		System.out.println("Teacher is writing, " + str);

		while(count != 0) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		text = str;
		count = noOfStudents;
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		notifyAll();
	}
	
	synchronized public String read() {
		while(count == 0) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		if(count == 0) {
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			notify();
		}
		return text;
	}
}

class Teacher extends Thread {
	Board board;
	String str[] = {"Rapidsoft Technologies", "is an IT services", "and product company"};
	
	Teacher(Board board) {
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < str.length; i++) {
			board.write(str[i]);
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Student extends Thread {
	Board board;
	String name;
	
	Student(Board board, String name) {
		this.board = board;
		this.name = name;
	}
	
	@Override
	public void run() {
		String text;
		board.attendance();
		do {
			text = board.read();
			System.out.println(name + " is reading - " + text);
		
//			try {
//				Thread.sleep(1000);
//			} catch(InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.flush();
		}while(!text.equals("company"));
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		Teacher teacher = new Teacher(board);
		
		Student std1 = new Student(board, "Narendra Modi");
		Student std2 = new Student(board, "Amit Shah");
		Student std3 = new Student(board, "Navin Pattnaik");
		Student std4 = new Student(board, "Yogi");
		
		teacher.start();
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
	}

}
