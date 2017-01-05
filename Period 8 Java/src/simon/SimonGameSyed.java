package simon;

import guiPractice.GUIApplication;

public class SimonGameSyed extends GUIApplication {

	public SimonGameSyed(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenSyed s = new SimonScreenSyed(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGameSyed game = new SimonGameSyed(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}