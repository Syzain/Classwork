package introduction;

public class Student {
	//fields
	private String name;
	
	//constructor(initialize fields)
	public Student(String name){
		this.name = name;
	}
	public void talk(){
		System.out.println("Hi, my name is "+name);
	}
}
