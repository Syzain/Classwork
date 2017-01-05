package caveExplorer;

public class Inventory {

	private boolean hasMap;
	private String map;
	
	public Inventory() {
		hasMap = false;
		updateMap();
	}
	
	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public void updateMap() {
		CaveRoom[][] caves = CaveExplorer.caves;
		//create the top side
		map = "";
		//horizontal line across top row, except for last column, width 4
		for(int i = 0; i < caves[0].length; i++){
			map += "____";
		}
		map += "___\n";
		
		//each room
		for(CaveRoom[] row: caves){
			//there are 3 rows of text
			for(int textRow = 0; textRow < 3; textRow++){
				//the text is for each row
				for(CaveRoom cr : row){
					String str = "|   ";
					String contents = cr.getContents();
					if (textRow == 1 && cr.getDoor(CaveRoom.WEST) != null){
						str = " " + contents + " ";
					}else if(textRow == 2){
						if(cr.getDoor(CaveRoom.SOUTH) == null){
							str = "|___";
						}else{
							str = "|_ _";
						}
					}
					map += str;
				}
				//end of row of caverooms
				map += "|\n";
			}
		}
		
	}

	public String getDescription() {
		if(hasMap){
			return map;
		}else{
			return "You have no inventory.";
		}
	}
}