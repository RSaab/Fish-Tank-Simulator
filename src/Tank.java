/* Rashad Saab */

import java.util.Arrays;


public class Tank {
	
	public static Fish[] fish=new Fish[10]; // This array simulates the fish in the tank 
	public static Food[] food=new Food[20]; // This array simulates the food in the tank
	private static int stepNumber=0;	//Number of steps. A step is a unit of time. Explained later
	
	public Tank() {
		
	}
	
	// fills fish and food arrays randomly
	public static void populate()
	{
		for(int i=0; i<food.length; i++)
		{
			food[i]=new Food();
			if(i<fish.length){
				fish[i]=getRandomFish();
			}
		}
	}
	
	private static Fish getRandomFish()
	{
		Fish[] f={new OmnivoresFish(), new CarnivoresFish(), new HerbivoresFish()};
		return f[(int) (Math.random()*3)];
	}
	
	public String toString(){
		
		return Arrays.deepToString(fish)+"\n"+Arrays.deepToString(food)+"\n"+stepNumber;
	}
	
	public static int getStepNumber(){
		return stepNumber;
	}
	
	public static void step()
	{
		for(int i=0; i<fish.length; i++)
		{
			fish[i].step();
		}
		if(stepNumber%3==0)
		{
			increaseHungerAndTiredness();
		}
		stepNumber++;
	}
	
	private static void increaseHungerAndTiredness(){
		for(int i=0; i<fish.length; i++){
			if(fish[i].getDead()==false){
				fish[i].hunger+=1;
				fish[i].tiredness+=1;
				fish[i].checkDeath();
			}
		}
	}
}
