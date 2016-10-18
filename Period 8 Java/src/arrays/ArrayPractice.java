package arrays;

public class ArrayPractice {
	
	static boolean[] boos3;

	public static void main(String[] args){
		long currentTime = System.currentTimeMillis();
		
		int[] fiftyNumbers = new int[50];
		populate(fiftyNumbers);
		print(fiftyNumbers);
		randomize(fiftyNumbers);
		print(fiftyNumbers);
		rollDice(fiftyNumbers);
		countResults(fiftyNumbers);
		
		long endTime = System.currentTimeMillis();

		System.out.println("The process took "+(endTime-currentTime+"ms."));
	}
	private static void countResults(int[] fiftyNumbers) {
		int[] counter = new int[12];
		for(int n:fiftyNumbers){
			counter[n-1] = counter[n-1] + 1;
		}
		for(int i = 0; i< counter.length; i++){
			System.out.println((i+1) + " was rolled "
			+ 2*counter[i]/100 + " percent of the time");
		}
		
	}
	private static void rollDice(int[] fiftyNumbers) {
		for(int i = 0; i< fiftyNumbers.length; i++){
			double random = Math.random();
			int roll = (int) (6*random);
			roll++;
			double random2 = Math.random();
			int roll2 = (int) (6*random2);
			roll2++;
			fiftyNumbers[i] = (int) (roll+roll2);
			System.out.println("#"+(i+1)+" "+fiftyNumbers[i]);
			
		}
	}
	private static void randomize(int[] fiftyNumbers) {
		for(int i = 0; i< fiftyNumbers.length; i++){
			fiftyNumbers[i] = (int) (Math.random() * 50);
		}
	}
	private static void print(int[] fiftyNumbers) {
		for(int i = 0; i< fiftyNumbers.length; i++){
			System.out.println(fiftyNumbers[i]);
		}
		
	}
	private static void populate(int[] fiftyNumbers) {
		for(int i = 0; i< fiftyNumbers.length; i++){
			int string=(i+1);
			fiftyNumbers[i] = string;
		}
		
	}
	private void demonstratePassByValue(){	
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		someStrings[999] = getASpecialString();
		print(someStrings);
		
	}
	private static String getASpecialString(){
		String s = "This string is pretty special";
		return s;
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
