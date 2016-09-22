package introduction;

public class DataTypes {

	public static void main(String[] args) {
		System.out.println(5.0/2);
		System.out.println((double) 5/2);
		System.out.println(5/2);
		System.out.println(3+5.0/2+5*2);
		System.out.println(3.0+5/2+5*2);
		System.out.println((int)(3.0 + 5)/(2 + 5 * 2));

		double d1 = 4.64; 
		double d2 = 2.0;
		double d3 = 2.64;
		System.out.println("d1 : " + d1); 
		System.out.println("d2 : " + d2); 
		System.out.println("d3 : " + d3);  
		System.out.println("d1 - d2 : " + (d1 - d2));
		
		String ten="10";
		String two="2";
		if(ten.compareTo(two)>0)System.out.println("10 is greater than two");
		else System.out.println("10 is not greater than two");
	}

}
