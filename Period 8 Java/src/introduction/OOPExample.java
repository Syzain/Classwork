package introduction;

public class OOPExample {

	public static void main(String[] args) {
		Student swagboysyed = new Senior("SwagboySyed");
		swagboysyed.talk();
		Student bob = new Junior("Bob");
		bob.talk();
		Student rob = new Sophomore("Rob");
		rob.talk();
	}

}
