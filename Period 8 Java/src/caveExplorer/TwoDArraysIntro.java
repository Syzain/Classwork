package caveExplorer;

import java.util.Arrays;
	import java.util.Scanner;

	public class TwoDArraysIntro {
		
		public static Scanner in = new Scanner(System.in);
		static String[][] arr2d;
		static String[][] pic;
		static int starti;
		static int startj;
		static int treasurei;
		static int treasurej;

		public static void main(String[] args) {
			arr2d = new String[5][5];
			pic = new String[5][5];
			for(int row = 0; row < arr2d.length; row++){
				for(int col = 0; col < arr2d[row].length; col++){
					arr2d[row][col] = "(" + row + ", " + col + ")";
				}
			}
			starti = 2; 
			startj = 2;
			treasurei = 4;
			treasurej = 3;
			startExploring();
			
			
		}
		
		private static void startExploring() {
			while(true){
				printGridWithPosition(pic.length, pic[0].length);
				//printPic(pic);
				
				System.out.println("You are in room: " + arr2d[starti][startj] + "."); //prints description of the room
				
				if(starti == treasurei && startj == treasurej){
					break;
				}
				System.out.println("What do you want to do?");
				String input = in.nextLine();
				int[] newCoordinates = interpretInput(input);
				starti = newCoordinates[0];
				startj = newCoordinates[1];
			}
			System.out.println("Congrats you found the treasure, you win");
		}
		public static void printGridWithPosition(int row, int col){
			for(int c = 0; c < col; c++){
				System.out.print(" _ _ _");
			}
			for(int r = 0; r < row; r++){
				System.out.print("\n");
				for(int i = 0; i < 3; i++){
					if(i == 2){
						for(int c = 0; c < col; c++){
							System.out.print("|_ _ _");
						}
						System.out.print("|");
					}
					else{
						for(int c = 0; c < col; c++){
							if(r == starti && c == startj && i == 1){
								System.out.print("|  x  ");
							}
							else{
								System.out.print("|     ");
							}
						}
					System.out.print("| \n");
					}
				}
			}
		}
		private static int[] interpretInput(String input) {
			//check if input is valid
			while(!isValid(input)){
				System.out.println("Sorry, in this game, you can only use the w, a, s, d controls. Tell me again what you would like to do");
				input = in.nextLine();
			}
			int currenti = starti;
			int currentj = startj;
			input = input.toLowerCase();
			if(input.equals("w")){
				currenti --;
			}
			if(input.equals("s")){
				currenti ++;
			}
			if(input.equals("a")){
				currentj --;
			}
			if(input.equals("d")){
				currentj ++;
			}
			int[] newCoordinates = {starti, startj};
			if(currenti >= 0 && currenti < arr2d.length && currentj >=0 && currentj < arr2d[0].length){
				newCoordinates[0] = currenti;
				newCoordinates[1] = currentj;
			}
			else{
				System.out.println("sorry you've reached the end of the universe you cannot go farther in that direction");
			}
			return newCoordinates;
		}

		private static boolean isValid(String input) {
			String[] validKeys = {"w", "a", "s", "d"};
			for(String key: validKeys){
				if(input.toLowerCase().equals(key)){
					return true;
				}
			}
			return false;
		}

		public static void mineSweeper(){
			boolean[][] mines = new boolean[6][6];
			plantMines(mines);
			String[][] field = createField(mines);
			printPic(field);
		}
		
		private static String[][] createField(boolean[][] mines) {
			String[][] field = new String[mines.length][mines[0].length]; 
			
			for(int row = 0; row < field.length; row++){
				for(int col = 0; col < field[row].length; col++){
					if(mines[row][col]){
						field[row][col] = "X";
					}
					else{
						field[row][col] = countNearby(mines, row, col);
					}
				}
			}
			return field;
		}

		private static String countNearby(boolean[][] mines, int row, int col) {
			for(int r = row -1; r <= row + 1; r++){
				for(int c = col - 1; c <= col + 1; c++){
					//this is one way to avoid index out of bounds exception
					if(r >= 0 && r < mines.length && c >= 0 && c < mines[0].length){
						
					}
				}
			}
			int count = 0;
			count += isValidAndTrue(mines, row - 1, col);
			count += isValidAndTrue(mines, row + 1, col);
			count += isValidAndTrue(mines, row, col - 1);
			count += isValidAndTrue(mines, row, col + 1);
			return ""+count; // Concatenate int to an empty string to make it a string
		}

		private static int isValidAndTrue(boolean[][] mines, int i, int j) {
			if(i >= 0 && i < mines.length && j >= 0 && j < mines[0].length && mines[i][j]) return 1;
			else return 0;
		}

		private static void plantMines(boolean[][] mines) {
			int numberOfMines = 10;
			int row;
			int col;
			while(numberOfMines > 0){
				row = (int)(Math.random() * mines.length); //you don't need to add 1 because 0 will be a an index of the array
				col = (int)(Math.random() * mines[0].length); 
				//this prevents the same mine from being selected twice
				if(!mines[row][col]){
					mines[row][col] = true;
					numberOfMines --;
				}
			}
			
		}

		
		
		public static void printPic(String[][] arr){
			for(String[] row : arr){
				for(String col : row){
					System.out.print(col);
				}
				System.out.print("\n");
			}
		}
		
		
		public static void drawFace(){
			String[][] pic = new String[10][8];
			
			//grassy field 
			for(int row = 0; row < pic.length; row++){
				for(int col = 0; col < pic[row].length; col++){
					pic[row][col] = " ";
				}
			}
			
			for(int row = 5; row < pic.length; row++){
				for(int col = 0; col < pic[row].length; col++){
					pic[row][col] = "w";
				}
			}
			
			
			int snow = 7;
			while(snow > 0){
				pic[(int)(Math.random() * 9) + 1][(int)(Math.random() * 6) + 1] = "*";
				snow--;
			}
			
			//for(int row = 0; row < pic.length; row++){
			//	for(int col = 0; col < pic[row].length; col++){
			//		pic[row][col] = "(" + row + ", " + col + ")";
			//	}
			//}
			
			for(String[] row : pic){
				for(String col: row){
					System.out.print(col);	
				}
				System.out.print("\n");
			}
		}
		
		public static void drawGrass(){
			
		}
		
		public static void printPicBorder(String[][] pic){
				for(int col = 0; col < pic[0].length; col++){
					pic[0][col] = "_";
					pic[pic.length - 1][col] = "_";
				}
				for(int row = 1; row < pic.length; row++){
					pic[row][0] = "|";
					pic[row][pic[0].length - 1] = "|";
				}
				
				//give the picture a border initial attempt
				/*for(int row = 0; row < pic.length; row++){
					for(int col = 0; col < pic[row].length; col++){
						if(row == 0 || row == pic.length -1){
							pic[row][col] = "_";
						}
						else if(col == 0 || col == pic[row].length -1){
							pic[row][col] = "|";
						}
					}
				}*/
		}
		
		public static void intro(){
			String[] xox = {"x", "o", "x", "o","x"};
			System.out.println(Arrays.toString(xox)); //this method shows the array in horizontal brackets to visualize the array
			//a 1D array prints a horizontal string
			
			String[][] arr2D = new String[5][4]; //first number is the length of array, 2nd number is length of each array within the array
			
			System.out.println("The height is " + arr2D.length);
			System.out.println("The width is " + arr2D[0].length);
			for(int row = 0; row < arr2D.length; row++){
				for(int col = 0; col < arr2D[row].length; col++){
					arr2D[row][col] = "(" + row + ", " + col + ")";
				}
			}
			//print the 2D array
			//every element in a 2D array is itself an array
			//so a for each loop looks like this
			for(String[] row : arr2D){
				System.out.println(Arrays.toString(row));
			}
		}

	}
