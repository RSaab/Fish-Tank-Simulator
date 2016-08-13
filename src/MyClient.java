/* Rashad Saab */

import java.io.*;
import java.util.*;

public class MyClient {
	private static PrintStream out;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File status=new File("status.txt");
		out=new PrintStream(status);
		Tank t=new Tank();
		Tank.populate();
		out.println("Tank populated successfully\n\n\n");
		printStatusToFile(t);
		System.out.println("Press Enter to perform a Step or type 'quit' to exit: ");
		@SuppressWarnings("resource")
		Scanner user=new Scanner(System.in);
		String userInput=user.nextLine();
		System.out.println("Step: "+Tank.getStepNumber()+"\n");
		while(userInput.equalsIgnoreCase("")){
			Tank.step();
			out.println("Press Enter to perform a Step or type 'quit' to exit: ");
			out.println("Step: "+Tank.getStepNumber()+"\n");
			System.out.print("Press Enter to perform a Step or type 'quit' to exit: ");
			userInput=user.nextLine();
			System.out.println("Step: "+Tank.getStepNumber()+"\n");
			printStatusToFile(t);
		}
		if(userInput.equalsIgnoreCase("quit")){
			System.out.println("Stopped execution!!!");
			out.println("\n\nPress Enter to perform a Step or type 'quit' to exit: \nStopped execution!!!");
		}
		
	}
	
	public static void printStatusToFile(Tank t){
		String format="%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s";
		out.printf(format, "FISH", "TYPE", "SIZE", "SPEED", "HUNGER", "TIREDNESS", "DEAD","LAST ACTION", "LAST MEAL");
		out.println();
		for(int i=0; i<Tank.fish.length; i++)
		{
			Fish f=Tank.fish[i];
			out.printf(format, "fish"+i, f.getFishType(), f.getSize(), f.getSpeed(), f.getHunger(), f.getTiredness(), f.getDead(), f.getLastAction(), f.getLastMeal());
			out.println();
		}
		out.println("\n");

		//print list of food
		out.println("\nList of Food\n");
		out.printf("%-11s %-5s", "FOOD TYPE", "SIZE\n");
		
		for(int i=0; i<Tank.food.length; i++)
		{
			Food f=Tank.food[i];
			if(f!=null){
				out.printf("%-11s %-5s", f.getType(), f.getSize());
				out.println();
			}
			
		}
		out.println("\n");
	}

}
