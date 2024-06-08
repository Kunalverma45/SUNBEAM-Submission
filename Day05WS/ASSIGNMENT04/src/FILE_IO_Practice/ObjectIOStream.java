package FILE_IO_Practice;

import java.io.*;
import java.util.*;

// Want to read and write the Object inside the binary file
// OOS & OIS

class Employee implements Serializable{

	private static final long serialVersionUID = -589713096621803043L;
	String name;
	int age;
//	transient float salary;
	float salary;
	public Employee(String name, int age, float salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}

public class ObjectIOStream {
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
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(PATH_NAME))))){
			Employee emp1 = new Employee("Kunal Verma",20,20000);
			oos.writeObject(emp1);
			Employee emp2 = new Employee("Riya Raghuwanshi",21,40000);
			oos.writeObject(emp2);
			Employee emp3 = new Employee("YANA",5,300);
			oos.writeObject(emp3);
			System.out.println("Data Written Successfully...");
		}
	}
	
	public static void TBH_readRecord() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(PATH_NAME))))){
			Employee A = (Employee)ois.readObject();
			System.out.println(A);
			Employee B = (Employee)ois.readObject();
			System.out.println(B);
			Employee Y = (Employee)ois.readObject();
			System.out.println(Y);
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
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