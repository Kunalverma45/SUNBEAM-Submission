package FILE_IO_Practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TextBufferedRW {
	private static final String PATH_NAME = "Demoo.txt";
	// Aim to read or Write the multiple bit of data inside the binary file
	// 1 Extra Step Adding of BufferedOutputStream & BufferedInputStream
	// As they are Abstract Classes Named as - FileOutputStream or FileInputStream
	// This Abstract Classes are Extended from the Real I/OStream Files 
	
	static Scanner sc = new Scanner(System.in);
	
	public static int menuList(){		
		System.out.println("-------------------------------------------------------------"
				+ "\nEnter the Option:\n0. Exit\n1. Write By TBH\n2. Read By TBH");
		int choice = sc.nextInt();
		if (choice==0) {
			System.out.println("Exited...");
		}
		return choice;
	}
	
// Code of writeRecord() & readRecord() WITH Try Block Handler
	public static void TBH_writeRecord() throws FileNotFoundException, IOException{
		// TRY BLOCK HANDLER Will take some resource from the Try Block and can't contain the catch block
		// As we provided the source to the Try block we don't have to write anything extra for handle the exception as it throws automatically
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH_NAME)))){
			for (char ch = 'A';ch < 'z'; ch++) {
				bw.write(ch);
			}
		}
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(new File(PATH_NAME)))){
			int data;
			while ((data = br.read())!=-1) {
				System.out.print((char)data+" ");
			}
			System.out.println();
		}
		// not have to worry about the catch block
	}

	
	

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.out.println("Hello Guys!!");
		int choice;
		while ((choice = menuList())!=0){
			switch (choice) {
			case 1:
				TBH_writeRecord();
				break;
			case 2:
				TBH_readRecord();
				break;
			default:
				System.out.println("Put the valid input");
				break;
			}
		}
	}
}
