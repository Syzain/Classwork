package introduction;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;

	public static void main(String[] args) {
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
	}
	public static void promptName(){
		print("Enter your name");
		user = input.nextLine();
		print("Glad to meet you, "+user+".  For the rest of time, I will call you.  "
				+user+" You may call me Computer-Chan.  We should become friends.");
	}
	public static void promptForever(){
		while(true){
			promptInput();
		}
	}
	public static void promptInput(){
		print("Please type something");
		String userInput = input.nextLine();
		print("Congratulations! You Typed: "+userInput);
	}
	
	public static void createFields() {
		input = new Scanner(System.in);
		user = "";
	}
	
	public static void demonstrateStringMethods(){
		String text1 = new String("Hello World");
		String text2 = "Hello World";
		
		if(text1.equals(text2)){
		System.out.println("These strings are equal");
		}
		System.out.println(text1);
		print(text2);
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyve";
		
		if(word1.compareTo(word2) < 0){
			print("word 1 comes before word 2");
		}
	}
	public static void print(String s){
		String printString = s;
		int cutoff = 10;
		if(printString.length() > cutoff);{
			for(int i = 0; i <s.length(); i++){
			printString += getCut(s,cutoff, i+1)+"\n";
			}
		}
		System.out.println(printString);
	}
	private static String getCut(String s, int cutoff, int cut){
			int cutIndex = cut * cutoff;
			if(cutIndex >s.length()) cutIndex = s.length();
			String currentCut = s.substring(0,cutIndex);
		
			int indexOfLastSpace = currentCut.length()-1;
			for(int i = currentCut.length()-1; i>=0; i--){
				String letter = currentCut.substring(i,  i+1);
				if(letter.equals(" ")){
					indexOfLastSpace = i;
					break;
				}
			}	
			currentCut = currentCut.substring(0,indexOfLastSpace);
			return currentCut;
		
	}
}
