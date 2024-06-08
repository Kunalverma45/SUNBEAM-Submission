package FILE_IO_Practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BufferIO {
	private static final String PATH_NAME = "Demo.dat";
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
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(PATH_NAME)))){
			for (char ch = 'A';ch < 'z'; ch++) {
				bos.write(ch);
			}
		}
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException{
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(PATH_NAME)))){
			int data;
			while ((data = bis.read())!=-1) {
				System.out.print((char)data+" ");
			}
			System.out.println();
		}
		// not have to worry about the catch block
	}

	
	
	
// Code of writeRecord() & readRecord() WITHOUT Try Block Handler
	public static void writeRecord(){	
		// Object Creation & the class FOS cannot contain any default constructor or any parameterless constructor 
		// because the constructor have to link with any of the class or any data
		FileOutputStream fos = null;
		try {
			//Generation of link FOS--->File.dat
			fos = new FileOutputStream(new File(PATH_NAME));
			byte data = 123;
			fos.write(data);
			System.out.println("Data is Successfully Written...");
		} catch (Exception e) {e.printStackTrace();}
		finally {
			try {
				fos.close();
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public static void readRecord(){
		//Similar as the FileOutputStream Method 
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(PATH_NAME));
			byte data = (byte)fis.read();
			System.out.println("Data is Successfully Readed = " + data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
