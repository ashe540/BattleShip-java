import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Player class that holds all of the player's information, such as his Board with the location of his ships,
 * the enemy board, the places he has already bombed, etc.
 */

public class Player {

	
	private String name;		
	private Socket socket;
	private boolean allShipsSunk;
	
	private Ship carrier;
	private Ship battleship;
	private Ship cruiser;
	private Ship submarine;
	private Ship destroyer;
	
	
	
	private String[][] Board= {
		
			{"   ","1","2","3","4","5","6","7","8","9","10"},
			{"A |","~","~","~","~","~","~","~","~","~","~","|"},
			{"B |","~","~","~","~","~","~","~","~","~","~","|"},
			{"C |","~","~","~","~","~","~","~","~","~","~","|"},
			{"D |","~","~","~","~","~","~","~","~","~","~","|"},
			{"E |","~","~","~","~","~","~","~","~","~","~","|"},
			{"F |","~","~","~","~","~","~","~","~","~","~","|"},
			{"G |","~","~","~","~","~","~","~","~","~","~","|"},
			{"H |","~","~","~","~","~","~","~","~","~","~","|"},
			{"I |","~","~","~","~","~","~","~","~","~","~","|"},
			{"J |","~","~","~","~","~","~","~","~","~","~","|"},
		
	};
	
	private String[][] enemyBoard= {
			{"   ","1","2","3","4","5","6","7","8","9","10"},
			{"A |","~","~","~","~","~","~","~","~","~","~","|"},
			{"B |","~","~","~","~","~","~","~","~","~","~","|"},
			{"C |","~","~","~","~","~","~","~","~","~","~","|"},
			{"D |","~","~","~","~","~","~","~","~","~","~","|"},
			{"E |","~","~","~","~","~","~","~","~","~","~","|"},
			{"F |","~","~","~","~","~","~","~","~","~","~","|"},
			{"G |","~","~","~","~","~","~","~","~","~","~","|"},
			{"H |","~","~","~","~","~","~","~","~","~","~","|"},
			{"I |","~","~","~","~","~","~","~","~","~","~","|"},
			{"J |","~","~","~","~","~","~","~","~","~","~","|"},
		
	};
	
	
	public String getName(){return name;}
	public Socket getSocket(){return socket;}
	public String[][] getBoard(){return Board;}
	public String [][] getEnemyBoard(){return enemyBoard;}
	
	public Ship getCarrier(){return carrier;}
	public Ship getBattleShip(){return battleship;}
	public Ship getCruiser(){return cruiser;}
	public Ship getSubmarine(){return submarine;}
	public Ship getDestroyer(){return destroyer;}
	
	
	public boolean getAllShipsSunk(){return allShipsSunk;}
	
	
	public void setCarrier(Ship carrier){ this.carrier = carrier;}
	public void setBattleShip(Ship battleship){ this.battleship = battleship;}
	public void setCruiser(Ship cruiser){ this.cruiser = cruiser;}
	public void setSubmarine(Ship submarine){ this.submarine = submarine;}
	public void setDestroyer(Ship destroyer){ this.destroyer = destroyer;}
	
	
	
	
	public void setAllShipsSunk(boolean allShipsSunk){this.allShipsSunk = allShipsSunk;}
	
	
	
	public Player(String name, Socket socket){
		
		this.name = name;
		this.socket = socket;
		allShipsSunk = false;
		
	}
	
	
	 public OutputStream outputStream() throws Exception { return this.socket.getOutputStream(); }
	 
	 
	 public InputStream inputStream() throws Exception { return this.socket.getInputStream(); }
	 	 
	 
	 public PrintWriter output(){ 
	        try{
	            return new PrintWriter( this.outputStream(), true );
	        }
	        catch ( Exception e ){
	            System.err.println( "Something bad happened trying to get the output with current player. Sorry about that..." );
	            return null;
	        }
	    }
	 
	 
	 public Scanner input(){ 
	        try{
	            return new Scanner( this.inputStream() ); 
	        }
	        catch ( Exception e ){
	            System.err.println( "Something bad happened trying to get the input with current player. Sorry about that..." );
	            return null;
	        }     
	    }

		
		public String printBoard(){
			String res="";
			for(int i=0; i< Board.length;i++){
				res+="\n";
			for(int j=0; j<Board[i].length; j++){
				
				res+=Board[i][j]+" ";
				
				
			} //END J
		} // END OF I
			return res;
	}
	
		
		public String printEnemyBoard(){
			String res="";
			for(int i=0; i< enemyBoard.length;i++){
				res+="\n";
			for(int j=0; j<enemyBoard[i].length; j++){
				
				res+=enemyBoard[i][j]+" ";
				
				
			} //END J
		} // END OF I
			return res;
	}
		
		
		
		
		public void markEnemyBoardWater(char letter, int width){
			
			int height = Character.getNumericValue(letter)-9;
			
			enemyBoard[height][width] = "O";		
		}
		
		public void markEnemyBoardHit(char letter, int width){
			
			int height = Character.getNumericValue(letter)-9;
			
			enemyBoard[height][width] = "X";		
		}
		
			
		
		public void clearBoard(){
			
			for(int i=1; i< Board.length;i++){
				
				for(int j=1; j<Board[i].length; j++){
					
					if(i!=0 || j!=0) Board[i][j] = "o";
					
					
					
				} //END J
			} // END OF I
			
		}	

		
/*			
	 
	 public static void main(String[] args){
		 
		 
		 Player p1 = new Player("Miguel");
		 
		 p1.addShip(2, 'A', 6);
		 p1.addShip(3, 'E', 4);
		 
		System.out.println( p1.printBoard());
		 
		 
		 
	 }
	 
	*/ 
}
