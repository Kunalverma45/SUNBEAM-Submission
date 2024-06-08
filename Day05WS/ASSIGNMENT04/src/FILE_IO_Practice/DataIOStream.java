package FILE_IO_Practice;

import java.io.*;
import java.util.*;

public class DataIOStream {
	private static final String PATH_NAME = "Demo.dat";
	
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
	
	public static void TBH_writeRecord() throws FileNotFoundException, IOException{
		try(DataOutputStream Dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(PATH_NAME))))){
			Dos.writeUTF("Rom rom bhaiyoo, System Fad denge!!!");
			Dos.writeInt(459);
			Dos.writeFloat(1439.55f);
			
		}
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException{
		try(DataInputStream Dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(PATH_NAME))))){
			String name = Dis.readUTF();
			int num = Dis.readInt();
			float var = Dis.readFloat();
			System.out.println("Name = "+ name + ",\nNumber = " + num +
								",\nFloat = "+ var+"/-");
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int choice;
		while ((choice = menuList())!=0){
			switch (choice) {
			case 1: TBH_writeRecord(); break;
			case 2: TBH_readRecord();  break;
			default: System.out.println("Put the valid input"); break;
			}
		}
	}
}