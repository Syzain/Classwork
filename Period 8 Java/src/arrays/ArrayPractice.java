package arrays;

public class ArrayPractice {
	
	static boolean[] boos3;

	public static void main(String[] args){
		long currentTime = System.currentTimeMillis();
		initializingArraysExample();
		long endTime = System.currentTimeMillis();
		
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		print(someStrings);
		
		System.out.println("The process took "+(endTime-currentTime+"ms."));
	}
	private static void makeSpecial(String s) {
		s = "This string is special to my heart";
		
	}
	private static void print(String[] s) {
		for(int i = 0; i< s.length; i++){
			System.out.println(s[i]);
		}
		
	}
	public static void standardPopulate(String[] s){
		for(int i = 0; i< s.length; i++){
			s[i] = "String #"+(i+1);
		}
	}
	
	public static void initializingArraysExample(){
		
		boolean[] boos1 = new boolean[3];
		boolean[] boos2 = {false, false, false};
		boos3 = new boolean[3];
		
		//two ways to iterate through array(for loop)
		/**
		 Standard for loop
		 -this index is important to keep track of
		 -you need to customize the order
		 */
		for(int i = 0; i < boos1.length; i++){
			System.out.println(boos1[i]);
		}
		/**
		 For each loop
		 -this index is not important
		 -you don't need to customize
		 -automatically assigns a "handle"
		 -speedy like blue sound barrier breaking hedgehogs
		 */
		for(boolean b: boos1){
			System.out.println(b);
		}
		
		String[] someStrings1 = new String[3];
		//someStrings1[0] = "a";
		//someStrings1[1] = "b";
		//someStrings1[2] = "c";
		//String[] someStrings2 = {"a","b","c"};
		
		for(int i=0;i<someStrings1.length;i++){
			someStrings1[i] = "a new String";
		}
		for(String s:someStrings1){
			System.out.println(s);
		}
	}

}
