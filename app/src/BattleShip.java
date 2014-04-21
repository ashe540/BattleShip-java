import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class BattleShip extends CommunicationMechanics {

	
	static int carrier=1, battleship=1, cruiser=1, submarine=1, destroyer=1;
	
	
	static int positionX;
	static int positionY;
	
	static String bombarded;
	static String opponentMessage = "";
	
	
	
	public BattleShip(ArrayList<Player> players){
	
		this.players = players;
	}
	
/**
 * Gives the illusion of waiting without hanging the thread (given a number k in seconds) 
 */

	
	public void wait(int k){
		  long time0, time1;
		  time0 = System.currentTimeMillis();
		  do{
		  time1 = System.currentTimeMillis();
		  }
		  while (time1 - time0 < k * 1000);
	  }	
	
	
	public void start(){

			   for(int i=0; i<20;i++){
				   this.printmessage("\n");
				   
			   }
						   
	this.printmessage("Welcome, we hope you enjoy this game of...\n");
	wait(1);
	this.printmessage("01000010011000010111010001110100011011000110010");
	wait(4);
	this.printmessage("And for those of you that don't speak in binary...");
	wait(2);
	this.printmessage("Welcome... to...");
	wait(3);
	for(int i=0; i<20;i++){
		   
		this.printmessage("\n");
		   
	}
	this.printmessage("__________         __    __  .__           _________.__    .__        ");
	this.printmessage("\\______   \\_____ _/  |__/  |_|  |   ____  /   _____/|  |__ |__|_____  ");
	this.printmessage(" |    |  _/\\__  \\   __\\   __\\  | _/ __ \\ \\_____  \\ |  |  \\|  \\____ \\ ");
	this.printmessage(" |    |   \\ / __ \\|  |  |  | |  |_\\  ___/ /        \\|   Y  \\  |  |_> >");
	this.printmessage(" |______  /(____  /__|  |__| |____/\\___  >_______  /|___|  /__|   __/ ");
	this.printmessage("        \\/      \\/                     \\/        \\/      \\/   |__|    ");
	wait(3);
	this.printmessage( "\n\n\tSet sails, you scullywags! We have the wind on er side!");
	wait(4);
	
	this.greetings();

	}
	
	public void greetings(){
		
		 for(int i=0; i<30;i++){
			   this.printmessage("\n");
			   
		   }
		
		this.printmessage("\nGreetings captain! Your fleet consists of 5 ships. 1 Carrier, 1 Battleship"); 
		this.printmessage("1 Cruiser, 1 Submarine and 1 Destroyer. What would you have me do with these?\n");
		this.setShips();	
	}
	
	
	
	public void setShips(){
	int saveSpace = 0;	
	int key=1;
		
	for( Player somePlayer : players){
		

	
	players.get(key).output().println("\nPlease wait while other player sets his board. Thank you for your patience.");
	players.get(1).output().println(players.get(key).printBoard());
	
	if(saveSpace ==1) somePlayer.output().println("\n\n\n\n");
	
		players.get(key).output().println("\n    _~");
		players.get(key).output().println(" _~ )_)_~");
		players.get(key).output().println(" )_))_))_)");
		players.get(key).output().println(" _!__!__!_");
		players.get(key).output().println(" \\______t/");
		players.get(key).output().println("~~~~~~~~~~~~~");
	
	
	
		carrier=1; battleship=1; cruiser=1; submarine=1; destroyer=1;	
		this.choosePos(somePlayer);
		key--; saveSpace++;

	}
	
	
	
 startPreliminaries();
	
	} // END of SETSHIPS

/**
 * Validates the coordinates given by the user (using regex)
 */

	public boolean validate(String pos, String num){
				
		return Pattern.matches("[a-j]+", pos) && Pattern.matches("([1-9]|1[0])+", num);
				
	}

static int semaphore = 0;
static int numOfLineBreaks = 4;




public void choosePos(Player somePlayer){
	
if(semaphore!=0){
	
	for(int i=0; i< numOfLineBreaks; i++){
		
		somePlayer.output().println();
		
	}
}

	semaphore++;
	numOfLineBreaks++;

	this.printTo(somePlayer.printBoard(), somePlayer);
	
	if(carrier > 0 || battleship > 0 || cruiser > 0 || submarine > 0 || destroyer > 0){	
	
	this.printTo("\nChoose vessel: (Write full name) ", somePlayer);
	if(carrier==1) this.printTo("Carrier (size 2)", somePlayer);
	if(battleship==1) this.printTo("Battleship (size 3)", somePlayer);
	if(cruiser==1) this.printTo("Cruiser (size 3)", somePlayer);
	if(submarine==1) this.printTo("Submarine (size 4)", somePlayer);
	if(destroyer==1) this.printTo("Destroyer (size 5)\n", somePlayer);
	
	String shiptype = somePlayer.input().nextLine().toLowerCase().trim(); 
	
	try{
		
		
		
		this.printTo("Choose position (From A to J)", somePlayer);
		String pos = somePlayer.input().nextLine().toLowerCase();
		this.printTo("Choose number (From 1 to 10)", somePlayer);
		String num = somePlayer.input().nextLine();
	
		
		if(validate(pos,num)){
			
			char letter = pos.charAt(0);
			int number = Integer.parseInt(num);
			
int shiptypeNum = 0;
            
            if(shiptype.equals("carrier")) shiptypeNum = 0;
            if(shiptype.equals("battleship")) shiptypeNum = 1;
            if(shiptype.equals("cruiser")) shiptypeNum = 2;
            if(shiptype.equals("submarine")) shiptypeNum = 3;
            if(shiptype.equals("destroyer")) shiptypeNum = 4;
            
            
    
            switch(shiptypeNum){
            
            case 0:
                
                if(carrier==1){
                    Ship ship = new Ship(2, Character.getNumericValue(letter)-9, number);
                    addShip(2, letter, number, somePlayer, ship);
                    somePlayer.setCarrier(ship);
                    carrier--; 
                      } else throw new InputMismatchException(); 
        
                                break;
            case 1:
                if(battleship==1){
                    Ship ship = new Ship(3, Character.getNumericValue(letter)-9, number);
                    addShip(3, letter, number, somePlayer, ship);
                    somePlayer.setBattleShip(ship);
                    battleship--; 
          } else throw new InputMismatchException();
                
                            break;
            case 2 :
                if(cruiser==1){
                    Ship ship = new Ship(3, Character.getNumericValue(letter)-9, number);
                    addShip(3, letter, number, somePlayer, ship);
                    somePlayer.setCruiser(ship);
                    cruiser--; 
          } else throw new InputMismatchException();
                            break;
            case 3:
                if(submarine==1){
                    Ship ship = new Ship(4, Character.getNumericValue(letter)-9, number);
                    addShip(4, letter, number, somePlayer, ship);
                    somePlayer.setSubmarine(ship);
                    submarine--; 
          } else throw new InputMismatchException();
                            break;
                            
            case 4:
                if(destroyer==1){
                    Ship ship = new Ship(5, Character.getNumericValue(letter)-9, number);
                    addShip(5, letter, number, somePlayer, ship);
                    somePlayer.setDestroyer(ship);
                    destroyer--; 
          } else throw new InputMismatchException();
                            break;
            default:
                    throw new InputMismatchException();
                        
            } // END SWITCH 
			
	System.out.println("Carrier: "+carrier);
	System.out.println("Battleship: "+battleship);
	System.out.println("Cruiser: "+cruiser);
	System.out.println("Submarine: "+submarine);
	System.out.println("Destroyer: "+destroyer);
	System.out.println("=================================");
	
	
	
			
			choosePos(somePlayer);
	}
	
//	somePlayer.setBoard(somePlayer.getBoard());
	
		
		else throw new InputMismatchException();
	
		
		}catch(InputMismatchException ime){
			for(int i=0; i<10;i++){
				somePlayer.output().println();
			}
		
		this.printTo("Wrong input. Please try again "+ somePlayer.getName() + ".", somePlayer);
		semaphore=0;
		choosePos(somePlayer);
						}	
	}	
}
	
/**
 * Method to add a Ship to a player's board
 */
	
public void addShip(int size, char letter, int width, Player somePlayer, Ship ship){
		
	
	
		int height = Character.getNumericValue(letter)-9;
				
		this.printTo("Would you like to place the ship horizontally (1) or vertically (2)", somePlayer);
		
		try{
			
		switch(somePlayer.input().nextInt()){
		
		case 1:	
		
			if(somePlayer.getBoard()[height][width+size] == null){
				throw new ArrayIndexOutOfBoundsException();
			}
			boolean isOK = true;
			
				for(int j=0; j< size; j++){
				
				if(somePlayer.getBoard()[height][width+j] == "X") isOK = false;
							
			}
			
				if(isOK){
					
					for(int i=0; i<size; i++){
						
					somePlayer.getBoard()[height][width+i] = "X";
					ship.saveShipCoordinates(height, width+i);
										
				}
					
			
			
				} else throw new ArrayIndexOutOfBoundsException();		
			
			
			break;
		
		
		case 2:
			if(somePlayer.getBoard()[height+size-1][width] == null){
				throw new ArrayIndexOutOfBoundsException();
			}
			boolean isOK2 = true;
			
			
			for(int j=0; j< size; j++){
				
				if(somePlayer.getBoard()[height+j][width] == "X") isOK2 = false;
							
			}
			if(isOK2){
				
			for(int i=0; i<size; i++){

				somePlayer.getBoard()[height+i][width] = "X";
				ship.saveShipCoordinates(height+i, width);
				
			}
		
	
			
			
			
		}else throw new ArrayIndexOutOfBoundsException();	
				
			break;
		
		
		default: 
			for(int i=0; i<10;i++){
				somePlayer.output().println();
			}
			somePlayer.output().println("Incorrect input, please try again.");
			addShip(size, letter, width, somePlayer, ship);
			semaphore =0;
				 break;
		}
		
		
		}catch(ArrayIndexOutOfBoundsException aoobe){
			for(int i=0; i<10;i++){
				somePlayer.output().println();
			}
			somePlayer.output().println("You cannot place a ship there. Try again.\n");
			semaphore = 0;
			choosePos(somePlayer);
					
		}	



		}


/**
 * Checks if the given coordinates correspond to a ship from the other player
 */

public boolean checkIfHit(char letter, int width, Player somePlayer){
	
	int height = Character.getNumericValue(letter)-9;
	
	if(somePlayer.getBoard()[height][width].equals("X")){ 
		return true;		
	}
	else return false;
}

/**
 * Marks the given coordinate as hit
 */

public void markAsHit(char letter, int width, Player somePlayer){
	
	int height = Character.getNumericValue(letter)-9;
	
	somePlayer.getBoard()[height][width] = "X";		
}


public void startPreliminaries(){
	
	ArrayList<Player> otherPlayers = players;
	Player firstPlayer = otherPlayers.get(0);
	Player secondPlayer = otherPlayers.get(1);

	int key = 0;
		
	while(!firstPlayer.getAllShipsSunk() && !secondPlayer.getAllShipsSunk()){
	
		
		
		
		
	//Semaphore for turn-based mechanics
		if(key == 0){
			startGame(firstPlayer, secondPlayer, key);
			key++;
				}
		else if(key == 1){
			startGame(secondPlayer, firstPlayer, key);
			key--;}
	}
	
	
// ********	End Of Match Results *********
	
	if(firstPlayer.getAllShipsSunk()==true){
		firstPlayer.output().println("\nArrrr me heartie! We lost! Our fleet has been destroyed! Abandon ship!!");
		secondPlayer.output().println("\nArrr me heartie! Well done! Ne'er thought yud make it tis far!");
		this.finishGame();
	}
	else{
		secondPlayer.output().println("\nArrrr me heartie! We lost! Our fleet has been destroyed! Abandon ship!!");
		firstPlayer.output().println("\nArrr me heartie! Well done! Ne'er thought yud make it tis far!");
		
		this.finishGame();
	}
	
	
	
}


/**
 * Handles user interface mechanics
 */

public void startGame(Player somePlayer, Player otherPlayer, int key){
	
		
	try{	
			otherPlayer.output().println("\nPlease wait while opponent finishes his turn...");
			
			 for(int i=0; i<20;i++){
				   somePlayer.output().println();
				 }
			
			printTo(opponentMessage, somePlayer);
			this.printTo(somePlayer.printEnemyBoard(), somePlayer);
			somePlayer.output().println("\nCaptain! Awaiting orders! Where shall we steer our cannons?");
			somePlayer.output().println("\nEnter the coordinates. What letter shall it be?");
					
			String pos = somePlayer.input().next().toLowerCase();
			
		//	somePlayer.input().nextLine();
			
			somePlayer.output().println("\nEnter the coordinates. And the number?");
					
			String num = somePlayer.input().next();
			
			for(int i=0; i<10;i++){
				   somePlayer.output().println();
				 }
			
			if(validate(pos,num)){
				
				char letter = pos.charAt(0);
				int number = Integer.parseInt(num);
			
				if(checkIfHit(letter, number, otherPlayer)){
				
					
					
					if(somePlayer.getEnemyBoard()[Character.getNumericValue(letter)-9][number] != "X"){
						
					markAsHit(letter, number, otherPlayer);
							
					
					somePlayer.markEnemyBoardHit(letter, number);
					this.printTo(somePlayer.printEnemyBoard(), somePlayer);
					int height = Character.getNumericValue(letter)-9;
					Ship ship = findShip(height, number, otherPlayer);
					
					if(!checkIfSunk(ship)) somePlayer.output().println("\nWe have a direct HIT!! Ready the cannons again!");
					
					
					opponentMessage = "\nCaptain, we have been HIT! Our "+bombarded+ " took some damage!";
					
					
					
					if(ship != null) deleteCoordinate(ship);
					
							
					if(ship != null && checkIfSunk(ship)){ 
						
						somePlayer.output().println("We sunk one of their ships!");
						opponentMessage +="\nThey've sunk our "+bombarded+"!";
					}
					
				}else{ somePlayer.output().println("We've already tried there! A cannon ball wasted!");
				this.printTo(somePlayer.printEnemyBoard(), somePlayer);}
					
				}else{
										
			if(somePlayer.getEnemyBoard()[Character.getNumericValue(letter)-9][number] != "O"){
					somePlayer.markEnemyBoardWater(letter, number);
					this.printTo(somePlayer.printEnemyBoard(), somePlayer);
					somePlayer.output().println("Arrgg me maties! Our aim was off! To the gallows with ye!");
					
				}else {somePlayer.output().println("We've already tried there! A cannon ball wasted!");
						this.printTo(somePlayer.printEnemyBoard(), somePlayer);}
			
					}
					
					
				}		
	
					
			else{
				opponentMessage = "Arrrgghh... our captain gave us strange coordinates. Hold off your attack!";
				throw new InputMismatchException();
				
			}
			
			checkIfLost(somePlayer);
			checkIfLost(otherPlayer);
			
	
	}catch(InputMismatchException ime){
		
		if(key==0) {
			
			key++;
			startGame(somePlayer, otherPlayer, key);
						
		}
		else{
			
			key--;
			startGame(otherPlayer, somePlayer, key);
			
		}
	}

	
	
	
} // END OF START GAME



/**
 * Checks if ALL ships have been sunk for a given player
 */

public void checkIfLost(Player somePlayer){
	
	if(checkIfSunk(somePlayer.getCarrier()) && checkIfSunk(somePlayer.getBattleShip()) && checkIfSunk(somePlayer.getCruiser()) && checkIfSunk(somePlayer.getSubmarine()) && checkIfSunk(somePlayer.getDestroyer())){
		somePlayer.setAllShipsSunk(true); }

}



/*
 *  If for every SHIP object, the coordinates array has been compromised entirely
 *  When a player makes a shot, it should remove from coordinates array the coordinate (2 values) setting them to 0
 *  When player shoots, program should go through all SHIP objects until finding the coordinate (findShip method) and return WHICH Ship was hit
 *  When we know which ship, we proceed to eliminate the values from the coordinates array.	
 */

/**
 * Deletes the corresponding coordinate from a Ship when it has been hit by the opponent
 */

public void deleteCoordinate(Ship ship){
	
	ship.getCoordinates()[positionX] = 0;
	ship.getCoordinates()[positionY] = 0;
	
}

public boolean checkIfSunk(Ship ship){
	
	boolean isEmpty = true;
	
	for(int i=0; i<ship.getCoordinates().length; i++){
		
	if(ship.getCoordinates()[i] != 0) isEmpty = false;
}
	return isEmpty;
}


/**
 * Returns the ship that has some given coordinates
 */

public Ship findShip(int height, int width, Player somePlayer){
	
	int i=0;
	int j=1;
	
	while(i< somePlayer.getCarrier().getCoordinates().length && j<somePlayer.getCarrier().getCoordinates().length){
		if(somePlayer.getCarrier().getCoordinates()[i] == height && somePlayer.getCarrier().getCoordinates()[j]==width){
				positionX = i;
				positionY = j;
				bombarded = "Carrier";
				return somePlayer.getCarrier();	}
		 i=i+2; j=j+2;		}
 
	i=0; j=1;
	
	while(i< somePlayer.getBattleShip().getCoordinates().length && j<somePlayer.getBattleShip().getCoordinates().length){
		if(somePlayer.getBattleShip().getCoordinates()[i] == height && somePlayer.getBattleShip().getCoordinates()[j]==width){
				positionX = i;
				positionY = j;
				bombarded = "BattleShip";
				return somePlayer.getBattleShip();	}
		 i=i+2; j=j+2;		}
	
	i=0; j=1;
	
	while(i< somePlayer.getCruiser().getCoordinates().length && j<somePlayer.getCruiser().getCoordinates().length){
		if(somePlayer.getCruiser().getCoordinates()[i] == height && somePlayer.getCruiser().getCoordinates()[j]==width){
			positionX = i;
			positionY = j;
			bombarded = "Cruiser";
			return somePlayer.getCruiser();	}
		 i=i+2; j=j+2;		}
	
	i=0; j=1;
	
	while(i< somePlayer.getSubmarine().getCoordinates().length && j<somePlayer.getSubmarine().getCoordinates().length){
		if(somePlayer.getSubmarine().getCoordinates()[i] == height && somePlayer.getSubmarine().getCoordinates()[j]==width){
			positionX = i;
			positionY = j;	
			bombarded = "Submarine";
			return somePlayer.getSubmarine();	}
		 i=i+2; j=j+2;		}

	i=0; j=1;
	
	while(i< somePlayer.getDestroyer().getCoordinates().length && j<somePlayer.getDestroyer().getCoordinates().length){
		if(somePlayer.getDestroyer().getCoordinates()[i] == height && somePlayer.getDestroyer().getCoordinates()[j]==width){
			positionX = i;
			positionY = j;
			bombarded = "Destroyer";
			return somePlayer.getDestroyer();	}
		 i=i+2; j=j+2;		}
	
	return null;
	
}

}