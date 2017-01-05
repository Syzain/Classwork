package caveExplorer;

public class CaveRoom {
	private String description;
	private String directions; //tells you where you could go
	private String contents; //tells you what's in the room
	private String defaultContents;

	private CaveRoom[] borderingRooms; //this is an array because there is more than one bordering room
	//every array index represents a certain direction so that we can maintain unity
	private Door[] doors; //doors is an array because there can be more than one room

	
	//final makes the variable a constant.. you cannot change it
	//capitalizing constants is a convention you should follow
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	//gives you a description of what the room is
	public CaveRoom(String description){
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents; 
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		//null means there are no bordering rooms
		//this code is not necessary because object arrays are initialized as null
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		//if there are no doors
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit. You will die here.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\n   There is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}
	
	}

	public static String toDirection(int dir) {
		String[] string = {"the North", "the East", "the South", "the West"};
		return string[dir];
	}

	public String getContents(){
		return contents;
	}
	
	//when you enter a room you change the contents to X because you are in the room
	public void enter(){
		contents = "X";
	}
	
	//when you leave the contents go back to the default contents
	public void leave(){
		contents = defaultContents;
	}
	
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	

	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}
	
	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}

	
	public String getDescription(){
		return description+directions;
	}

	public Door getDoor(int dir){
		return doors[dir];
	}


	public void setDescription(String string) {
		description = string;
	}

	public void interpretAction(String input) {
		while(!isValid(input)){
			CaveExplorer.print("Please enter 'w', 'a', 's', or 'd'");
			input = CaveExplorer.in.nextLine().toLowerCase();
		}
		String[] keys = {"w", "d", "s", "a"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(input)){
				indexFound = i;
				break;
			}
		}
		if(borderingRooms[indexFound] != null && doors[indexFound] != null && doors[indexFound].isOpen()){
			CaveExplorer.currentRoom = borderingRooms[indexFound];
		}
		CaveExplorer.currentRoom.leave();
		CaveExplorer.currentRoom = borderingRooms[indexFound];
		
		CaveExplorer.currentRoom.enter();
		CaveExplorer.inventory.updateMap();
	}

	public static boolean isValid(String input) {
		String[] keys = {"w", "d", "s", "a"};
		for(String key : keys){
			if(input.equals(key))return true; 
		}
		return false;
	}

	
}