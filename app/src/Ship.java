/**
 * Ship class that holds the information of each ship, such as the coordinates of all of his positions,
 * and the methods to operate with these coordinates.
 */


public class Ship {


	private int size;
	private int posX;
	private int posY;
	
	private int coordinates []; 
	
	
	public Ship(int size, int posX, int posY){
		
		
		this.size = size;
		this.posX = posX;
		this.posY = posY;
		this.coordinates = new int[10];
	}
	
	public int getSize(){ return size;}
	public int getPosX(){ return posX;}
	public int getPosY(){ return posY;}
	public int [] getCoordinates(){ return coordinates;}
	
	
	public void setSize(int size){this.size = size;}
	public void setPosX(int posX){this.posX = posX;}
	public void setPosY(int posY){this.posY = posY;}
	
	
	/**
	 * Saves given coordinate to the coordinates array for that ship
	 */	
	
	public void saveShipCoordinates(int height, int width){	
		
		boolean foundSpot = false;
		
		for(int i=0; !foundSpot && i< coordinates.length; i++){
			
			if(coordinates[i]== 0){
				
				coordinates[i] = height;
				coordinates[i+1] = width;
				
				foundSpot = true;
			} }
	}		
	
	
	/**
	 * Method for testing purposes. It allows to check what coordinates are taken by a specific ship
	 */
	
	
	public void printCoordinates(){
		for(int i=0; coordinates[i]!=0 && i< coordinates.length; i++){
		
			System.out.println(coordinates[i]);
		}
		
	}
	
	
	public String toString(){
		
				
		String res="I am a ship of " +size+ "size, at your service! Awaiting orders!";
								
		return res;
			
	}
	
	
}
