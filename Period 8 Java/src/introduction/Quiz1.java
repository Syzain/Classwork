package introduction;

import java.util.Scanner;

public class Quiz1 {
	static Scanner input = new Scanner(System.in);
	public static String waitForEntry(){
		return input.nextLine();
	}
	private static String username = "test_user";
	private static String password = "test";
	
	public static void main(String[] args) {
		if(correctUser()){
			askPassword();
		}
		else{
			System.out.println("Unknown username. Please contact "
					+ "the network administrator");
		}
	}
	private static boolean correctUser(){
		System.out.println("Enter username");
		return waitForEntry().equals(username);
	}
	private static void askPassword(){
		System.out.println("Enter password");
		for(int i = 2; i>=0; i--){
			if (waitForEntry().equals(password)){
				System.out.println("Congrats");
				break;
			}
			else{
				if (i==0){
					System.out.println("Invalid password");
				}
				else{
					System.out.println(i + " attempts left");
				}
			}
		}
	}

}
