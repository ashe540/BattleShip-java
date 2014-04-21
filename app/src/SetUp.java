import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SetUp {

	public static int MAX_CLIENTS    = 2;
    private static int port 		= 7777; /* port to connect to */
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static CommunicationMechanics comm;
   static int clients = 0;
	
  
    public static void run(){				  
	    
    	
    	System.out.println("There are 2 clients");
    		comm = new BattleShip(players);
	       
	       try
	       {
	    	   comm.start();
	    	   
	       }
	       catch ( Exception e )
	       {
	         System.out.println( "The wind is not on our sides anymore..." );
	       }
	       
	       System.out.println( "\n\n\tThanks for playing!" );
	   
    	
    	
		  }  
    
    
    
    
    
    public static void main(String[] args){
	
		
		
	  System.out.println( "Attempting to start server, please wait..." );
		       
	  try{
		   ServerSocket ss = new ServerSocket(port);
   

		   while(clients < MAX_CLIENTS){
	               
			   Socket socket = ss.accept();
	               
	               Scanner input = new Scanner( socket.getInputStream() ); 
	               PrintWriter output = new PrintWriter( socket.getOutputStream(), true );
	              
	       
	               
	          System.out.println( "\tUser connected:\t\t" + "Address: " +socket.getInetAddress());
	          output.println("\nPlease enter your name below: \n");
	          Player p1 = new Player(input.nextLine(), socket);
	          players.add(p1);
	          clients++;
	          System.out.println(clients+" clients connected so far.");
	          if(clients==1) output.println("Please wait for another player to join...");
	
	          
		   }
		   
		  run();
		   
		 

}catch(Exception e){
	
	
	
} //END OF CATCH CLAUSE
	
} // END OF MAIN

} // END OF SetUp Class
