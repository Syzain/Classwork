package introduction;

public class Senior extends Student {

	public Senior(String name) {
		super(name);
	}
	
	public void talk(){
		super.talk();
		System.out.println("...and I am the real slim shady");
	}
}
