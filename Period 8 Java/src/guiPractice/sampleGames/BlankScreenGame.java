package guiPractice.sampleGames;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class BlankScreenGame extends GUIApplication {


	@Override
	protected void initScreen() {
		Screen s = new BlankScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		new BlankScreenGame();
	}

}