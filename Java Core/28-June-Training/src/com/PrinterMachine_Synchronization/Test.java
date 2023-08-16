package com.PrinterMachine_Synchronization;

class Printer {
	
	synchronized public void printDocument(String document) {
		System.out.println("Printing document - " + document);
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(document + " printed");
	}
}

class PrintingTask extends Thread {
	Printer printer;
	String document;
	
	PrintingTask(Printer printer, String document) {
		this.printer = printer;
		this.document = document;
	}
	
	@Override
	public void run() {
		printer.printDocument(document);
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer printer = new Printer();
		PrintingTask task1 = new PrintingTask(printer, "Document 1");
		PrintingTask task2 = new PrintingTask(printer, "Document 2");
		
		task1.start();
		task2.start();
	}

}
