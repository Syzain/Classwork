package introduction;

public class Sophomore extends Student {

	public Sophomore(String name) {
		super(name);
	}
	
	public void talk(){
		super.talk();
		System.out.println("...and I know Snap!");
	}
}