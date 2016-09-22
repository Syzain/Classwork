package introduction;

public class RandomDiceRoll {

	public static void main(String[] args) {
		int[] results = new int[6];
		int totalRolls = 10000;
		for(int index = 0; index < totalRolls; index ++){
			int result = rollUnfairDie();
			System.out.println("Roll #"+(index+1)+": "+result);
			results[result-1]++;
		}
		for(int i = 0; i<6; i++){
			double percentage = (int) (1000*(double)results[i]/totalRolls)/10.0;
			System.out.println((i+1)+" appeared "+percentage +"%");
		}

	}
	
	public static int rollFairDie(){
		double rand=Math.random();
		int roll = (int) (6*rand);
		roll ++;
		return roll;
	}
	public static int rollUnfairDie(){
		double randomino=Math.random();
		int rolly = (int) (6*randomino);
		int rolly2 = (int) (2*randomino);
		rolly ++;
		 if (rolly2 == 1) {
	            rolly = 6;
		 }
	     return rolly;
	}
}

