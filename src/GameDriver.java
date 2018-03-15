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
