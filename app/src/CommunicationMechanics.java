import java.util.*;


public abstract class CommunicationMechanics{
	
    protected ArrayList<Player> players;
    
   
    public void printmessage( String message )
    {
    	for(Player somePlayer : players){
    	
        this.printTo( message, somePlayer );
        
        
    	}
    }
      
    public void printTo( String message, Player somePlayer )
    {
            somePlayer.output().println( message );
     }
              
       
    public void start() throws Exception{
        this.finishGame();
    						}
    
    public void finishGame(){
        this.printmessage( "\n\nThanks for playing!");
        System.exit(0);
    }
    
    
}
