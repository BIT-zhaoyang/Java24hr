package io.zhaoyang.java24hr.lesson15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassB {

	public static void main(String[] args) {
		Employee bestEmp = null;

		try(FileInputStream fIn = new FileInputStream("BestEmployee.ser");
			ObjectInputStream oIn = new ObjectInputStream(fIn);) {
			
			bestEmp = (Employee) oIn.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		System.out.println("The Employee object has been deserialized.");
		System.out.println(bestEmp);
	}

}
