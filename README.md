# -CSC275-Lab07

CSC 275 Lab 7

Instructor: Andrew S. Webb

Question Subject Line: CSC 275 Online Lab 7 Question


You are to develop an entire program that simulates the way a game is handled in the random creation of its characters. Your program should have the ability to create one of 3 types of character. The choices should be an ogre, archer and a swordsman. Each of these characters will share many of the same types of attributes such as name, life and energy and these should be contained in the Super class that we will call Entity (because Character is already a class).  Only the archer and the swordsman are playable, which leaves the ogre to be a Non-Player Character (NPC). This means that the Ogre will be a subclass of the Entity, while the archer and swordsman will be subclasses of Playable which is a subclass of Entity. Below is the diagram.  No changes need to be made to the driver.

 

The Playable class should extend the Entity class and should contain some additional methods that dictate the movement of the character by the user. Note that we will NOT be tracking the movement of the characters to help simplify the lab. The playable class should have a method for moving the character in the 4 standard directions (no diagonals allowed). So up, down, left and right. 

Class Name: Entity
	Class Level (global) Variables:
		strName 	- String
		intLife		- Integer
		intEnergy	- Integer

Method Name: getStrName
Parameters: None
Desired Result: Accessor
Data Returned: strName

Method Name: setStrName
Parameters: name
Desired Result: Mutator
Data Returned: none

Method Name: getIntLife
Parameters: None
Desired Result: Accessor
Data Returned: intLife

Method Name: setIntLife
Parameters: life
Desired Result: Mutator
Data Returned: none

Method Name: getIntEnergy
Parameters: None
Desired Result: Accessor
Data Returned: intEnergy

Method Name: setIntEnergy
Parameters: energy
Desired Result: Mutator
Data Returned: none


Class Name: Playable
Method Name: moveUp
Parameters: None
Data Returned: “ has moved up one space”

Method Name: moveDown
Parameters: None
Data Returned: “ has moved down one space”

Method Name: moveLeft
Parameters: None
Data Returned: “ has moved left one space”

Method Name: moveRight
Parameters: None
Data Returned: “ has moved right one space”


Class Name: Ogre
Method Name: Attack
Parameters: damageToInflict – Integer, playerToAttack - Entity
Desired Result: Attack an entity for x amount of damage
Data Returned: None

Class Name: Archer
Method Name: Attack
Parameters: damageToInflict - Integer, playerToAttack - Entity
Desired Result: Attack an entity for x amount of damage
Data Returned: None

Class Name: Swordsman
Method Name: Attack
Parameters: damageToInflict – Integer, playerToAttack - Entity
Desired Result: Attack an entity for x amount of damage
Data Returned: None



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameDriver {
	static ArrayList<Entity> myList = new ArrayList<Entity>();

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		for (int idx = 0; idx <= 5; idx++) {
			int randomInt = randomGenerator.nextInt(3);
			Entity temp = new Entity();
			switch (randomInt) {
				case 0:
					temp = new Archer();
					temp.setStrName("Archer" + idx);
					//System.out.println(temp.getStrName());
					break;
				case 1:
					temp = new Swordsman();
					temp.setStrName("Swordsman" + idx);
					//System.out.println(temp.getStrName());
					break;
				default:
					temp = new Ogre();
					temp.setStrName("Ogre" + idx);
					//System.out.println(temp.getStrName());
					break;
			}
			myList.add(temp);
		}
		
		while(true){
			// This leaves the possibility of a player attacking themselves.
			int randomInt = randomGenerator.nextInt(5);
			Entity player1 = myList.get(randomInt);
			System.out.println("Player 1: " + player1.getStrName());
			randomInt = randomGenerator.nextInt(5);
			Entity player2 = myList.get(randomInt);
			System.out.println("Player 2: " + player2.getStrName());
			
			
			if(player1 instanceof Archer){
				randomInt = randomGenerator.nextInt(1);
				if(randomInt == 0){ // Move
					randomInt = randomGenerator.nextInt(4);
					switch(randomInt){
						case 0: System.out.println(player1.getStrName() + ((Archer)player1).moveDown()); break;
						case 1: System.out.println(player1.getStrName() + ((Archer)player1).moveUp()); break;
						case 2: System.out.println(player1.getStrName() + ((Archer)player1).moveRight()); break;
						default: System.out.println(player1.getStrName() + ((Archer)player1).moveLeft()); break;
					}
				}else{ // Attack
					System.out.println("Attacking");
					randomInt = randomGenerator.nextInt(5);
					((Archer)player1).attack(randomInt, player2);
				}
			}else if(player1 instanceof Swordsman){
				randomInt = randomGenerator.nextInt(1);
				if(randomInt == 0){ // Move
					randomInt = randomGenerator.nextInt(4);
					switch(randomInt){
					case 0: System.out.println(player1.getStrName() + ((Swordsman)player1).moveDown()); break;
					case 1: System.out.println(player1.getStrName() + ((Swordsman)player1).moveUp()); break;
					case 2: System.out.println(player1.getStrName() + ((Swordsman)player1).moveRight()); break;
					default: System.out.println(player1.getStrName() + ((Swordsman)player1).moveLeft()); break;
					}
				}else{ // Attack
					System.out.println("Attacking");
					randomInt = randomGenerator.nextInt(5);
					((Swordsman)player1).attack(randomInt, player2);
				}
			}else{ // Player is an ogre
				System.out.println("Attacking");
				randomInt = randomGenerator.nextInt(5);
				((Ogre)player1).attack(randomInt, player2);
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter 1 to continue, 0 to quit.");
			int keepGoing = input.nextInt();
			if(keepGoing == 0){
				break;
			}
		}
	}
}

