package FILE_IO_Practice;

import java.io.*;
import java.util.*;

public class TextFileIOS {
	private static final String PATH_NAME = "Demoo.text";
	// Aim to read or Write the single bit of data inside the binary file
	// As they are Abstract Classes Named as - FileOutputStream or FileInputStream
	// This Abstract Classes are Extended from the Real I/OStream Files 
	
	static Scanner sc = new Scanner(System.in);
	
	public static int menuList(){		
		System.out.println("-------------------------------------------------------------"
				+ "\nEnter the Option:\n0. Exit\n1. Write\n2. Read");
		int choice = sc.nextInt();
		if (choice==0) {
			System.out.println("Exited...");
		}
		return choice;
	}
	
// Code of writeRecord() & readRecord() WITH Try Block Handler
	public static void TBH_writeRecord() throws FileNotFoundException, IOException{
		// TRY BLOCK HANDLER Will take some resource from the Try Block and can't contain the catch block
		try(FileWriter fr = new FileWriter(new File(PATH_NAME))){
			// As we provided the source to the Try block we don't have to write anything extra for handle the exception as it throws automatically
			fr.write("KR");
			System.out.println("Data is Successfully Written...");
		}
		// not have to worry about the catch block
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException{
		try(FileReader fr = new FileReader(new File(PATH_NAME))){
			char data = (char)fr.read();
			System.out.println("Data is Successfully Readed By TBH = " + data);
		}
		// not have to worry about the catch block
	}


	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.out.println("Hello Guys!!");
		int choice;
		while ((choice = menuList())!=0){
			switch (choice) {
			case 2:
				TBH_readRecord();
				break;
			case 1:
				TBH_writeRecord();
				break;
			default:
				System.out.println("Put the valid input");
				break;
			}
		}
	}
}
