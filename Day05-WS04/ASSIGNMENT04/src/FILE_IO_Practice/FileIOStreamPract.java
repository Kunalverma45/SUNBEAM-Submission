package FILE_IO_Practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileIOStreamPract {
	private static final String PATH_NAME = "Demo.dat";
	// Aim to read or Write the single bit of data inside the binary file
	// As they are Abstract Classes Named as - FileOutputStream or FileInputStream
	// This Abstract Classes are Extended from the Real I/OStream Files 
	
	static Scanner sc = new Scanner(System.in);
	
	public static int menuList(){		
		System.out.println("-------------------------------------------------------------"
				+ "\nEnter the Option:\n0. Exit\n1. Read\n2. Write\n3. Read By TBH\n4. Write By TBH");
		int choice = sc.nextInt();
		if (choice==0) {
			System.out.println("Exited...");
		}
		return choice;
	}
	
// Code of writeRecord() & readRecord() WITH Try Block Handler
	public static void TBH_writeRecord() throws FileNotFoundException, IOException{
		// TRY BLOCK HANDLER Will take some resource from the Try Block and can't contain the catch block
		try(FileOutputStream fos = new FileOutputStream(new File(PATH_NAME))){
			// As we provided the source to the Try block we don't have to write anything extra for handle the exception as it throws automatically
			fos.write(111);
			System.out.println("Data is Successfully Written...");
		}
		// not have to worry about the catch block
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException{
		try(FileInputStream fis = new FileInputStream(new File(PATH_NAME))){
			byte data = (byte)fis.read();
			System.out.println("Data is Successfully Readed By TBH = " + data);
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
				readRecord();
				break;
			case 2:
				writeRecord();
				break;
			case 3:
				TBH_readRecord();
				break;
			case 4:
				TBH_writeRecord();
				break;
			default:
				System.out.println("Put the valid input");
				break;
			}
		}
	}
}
