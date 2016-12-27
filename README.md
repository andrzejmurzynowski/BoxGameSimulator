# GameSimulator
Simulator of the Box Game

Minigame simulator:

The player see 15 boxes. 
The player opens box after box until a "Game over sign" is found. 
The boxes contain various rewards that are randomly divided between the boxes. 
The contents are: 
1x €100 
1x €40 
1x €30 
2x €20 
5x €5 
1x "Extra life". If this reward is picked, the next "Game over sign" is nullified. 
3x "Game over sign" - ends the game. 
When the game is over, the player gets an additional reward. It is chosen randomly from four options: 
€5 
€10 
€20 
"Second chance" - return to the game to the previous state. The next time the game is over, the "Second chance" option is disabled (only the three above options are available) 

Task: 
Find out the average euro value rewarded when playing one round of this game, using simulations or exact calculations 


Results:

Print out from the console simulation:

Symulation was run on the 100000 games.
Sum calculated using STREAM: 9926110
Sum calculated using FOREACH LOOP: 9926110
Average reward is: 99 Euro



