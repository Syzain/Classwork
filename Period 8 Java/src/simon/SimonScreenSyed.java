package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.ClickableScreen;

public class SimonScreenSyed extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceSyed[] button;
	private ProgressInterfaceSyed progress;
	private ArrayList<MoveInterfaceSyed> sequence; 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelected;

	public SimonScreenSyed(int w, int h) {
		super(w, h);
		Thread screen = new Thread(this);
		screen.start();
	}
	public void initAllObjects(List<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.blue, Color.pink, Color.orange, Color.green, Color.lightGray};
		String[] names = {"RED", "BLUE", "PINK", "ORANGE", "GREEN", "LIGHTGRAY"};
		int buttonCount = 6;
		button = new ButtonInterfaceSyed[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			button[i] = getAButton();
			button[i].setName(names[i]);
			button[i].setColor(colors[i]);
			button[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(buttonCount))));
			button[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(buttonCount))));
			final ButtonInterfaceSyed b = button[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			button[i].setAction(new Action() {

				public void act() {

						Thread buttonPress = new Thread(new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
								
							}
						});
						buttonPress.start();
						

						if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(acceptingInput){
							gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenSyed.this);
							nextRound.start();
						}
					}

			});
			viewObjects.add(button[i]);
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceSyed>();
		//add 2 moves to start
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;

		viewObjects.add(progress);
		viewObjects.add(label);
	}
	private MoveInterfaceSyed randomMove() {
		int select = (int) (Math.random()*button.length);
		while(select == lastSelected){
			select = (int) (Math.random()*button.length);
		}
		lastSelected = select;
		return new Move(button[select]);
	}

	private ProgressInterfaceSyed getProgress() {
		return new Progress();
	}

	private ButtonInterfaceSyed getAButton() {
		return new Button();
	}

	public void gameOver() {
		progress.gameOver();
	}
	public void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceLength(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		showSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void run() {
		changeText("");
		nextRound();
	}


	private void showSequence() {
		ButtonInterfaceSyed b = null;
		for(MoveInterfaceSyed m: sequence){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

}