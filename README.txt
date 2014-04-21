------------------------------------------------------------------------------
__________         __    __  .__           _________.__    .__        
\______   \_____ _/  |__/  |_|  |   ____  /   _____/|  |__ |__|_____  
|    |  _/\__  \   __\   __\  | _/ __ \ \_____  \ |  |  \|  \____ \ 
|    |   \ / __ \|  |  |  | |  |_\  ___/ /        \|   Y  \  |  |_> >
|______  /(____  /__|  |__| |____/\___  >_______  /|___|  /__|   __/ 
        \/      \/                     \/        \/      \/   |__|    
     				_____________________________________________
***************************     BattleShip: Based on classic Battleship game
Author: Miguel Martinez   *	Copyright (c) 2012-2013	
Computer Networking       *	World Wide Web: theskyfall.com
Project			  *	Report bugs to: contact@theskyfall.com		
2nd Year Computer Science *	_____________________________________________
Version: v0.1 Jan 2013    *	
			  *     
***************************

This compressed folder contains the following:

1) Presentation and information about the project (.PDF)
2) An executable JAR file
3) Source code


-----------------------------------------------------------------
HOW TO RUN THE PROGRAM:

***********
* STEP 1: *
***********

In order to run the program you must either (1) import the entire project to 
your favorite Java Integrated Development Environment, such as Eclipse,
NetBeans, BlueJ, etc; (2) or simply execute the executable JAR file . 

1) Using Eclipse:

For Eclipse simply go to File --> Import , go to the "General" tab and choose:
"Existing Projects into Workspace". Hit NEXT and then, for the root directory
option, after clicking Browse, choose the folder inside the zip file provided,
called "BattleShip". After succesfully importing, simply run the BSThread.java or
SetUp.java .

2) Running the executable JAR file

As simple as double clicking. Not much to it. If you get a message asking for
permissions make sure you accept.

***********
* STEP 2: *
***********

For the next step you must have NetCat installed, because it's the tool we'll be
using to connect to the game. 

If you don't have NetCat download it from here:

Windows: http://joncraton.org/media/files/nc111nt.zip

Linux: http://netcat.sourceforge.net/download.php

You might need to set the directory of the netcat executable to your PATH 
Environmental Variables. That, or have the exec netcat file in your current
directory.

*************************************************************************************
REMINDER: To change working directory on your terminal, type the command:
cd newDirectory -->  where newDirectory is a folder within your current directory; or
cd ..	        --> in case you want to go to set your current working directory 
		    as the parent directory.
To show files and folders:
Windows: Type dir
Linux  : Type ls
*************************************************************************************


After you've done any of these methods, proceed to open a terminal window. 

For Windows: Start button --> Type cmd --> Run cmd
For Linux: Should be easy to find somewhere.


***********
* STEP 3: *
***********

To connect to the computer running application that we executed in step 1 we must 
know the IP Address of the computer where it's running. Typing "ipconfig" (without 
quotes) in a terminal will easily show you your local IP address in the case of 
playing with another player in the same Internet connection.

After we know the IP address, to connect we type on somebody else's terminal the
command:

nc IPNUMBERGOESHERE 7777


For example: nc 192.168.1.153 7777

In case you, the person that's running the program would like to participate in the
game, you COULD use your own IP address, but you can also substitute it for localhost

nc localhost 7777

***********
* STEP 4: *
***********

And that's it! If you did everything correctly you should be playing already!

Good luck! And happy sinking!




-------------------------------------------------------------------------------------
Copyright © 2013, Miguel Martinez / theskyfall.com
All Rights Reserved.
-------------------------------------------------------------------------------------