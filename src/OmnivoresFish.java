/* Rashad Saab */

import java.util.Random;

public class OmnivoresFish extends Fish{

	private String preferredMeal; 	//Should be “Fish”, “Plant” or “Meat”

	public OmnivoresFish() 	// same functionality  as Fish() but also randomly initializes preferredMeal
	{
		super();
		String[] meals={"Fish", "Plant", "Meat"};
		preferredMeal=meals[(int) (Math.random()*3)];
	}

	@Override
	public boolean grow() {
		boolean grew=false;
		if(hunger<7 && tiredness<8){
			super.size+=1;
			super.speed+=1;
			super.hunger+=2;
			super.tiredness+=2;
			super.lastAction="grow";
			grew=true;
		}
		return grew;
	}

	@Override
	public boolean eat() {
		boolean ate=false;
		if(preferredMeal.equalsIgnoreCase("fish")){
			ate=eatFish();
			if(ate==false){
				Random r=new Random();
				if(r.equals(0)){
					ate=eatPlant();
				}else{
					ate=eatMeat();
				}
			}
		}else if(preferredMeal.equalsIgnoreCase("meat")){
			ate=eatMeat();
			if(ate==false){
				Random r=new Random();
				if(r.equals(0)){
					ate=eatPlant();
				}else{
					ate=eatFish();
				}
			}
		}else if(preferredMeal.equalsIgnoreCase("plant")){
			ate=eatPlant();
			if(ate==false){
				Random r=new Random();
				if(r.equals(0)){
					ate=eatMeat();
				}else{
					ate=eatFish();
				}
			}
		}
		if(ate==false)
		{
			super.setHunger(super.getHunger()+1);
		}
		return ate;
	}

	private boolean eatMeat(){
		int i=findMeatFood();
		if(i!=-1){
			Food f=Tank.food[i];
			super.hunger-=f.getSize();
			super.lastMeal=f.getType();
			super.lastAction="eat";
			Tank.food[i]=null;
			return true;

		}

		return false;
	}

	private int findMeatFood(){
		for(int i=0; i<Tank.food.length; i++)
		{
			if(Tank.food[i]!=null && Tank.food[i].getType().equalsIgnoreCase("Meat"))
			{
				return i;
			}
		}
		return -1;
	}

	private boolean eatPlant(){
		int i=findPlantFood();
		if(i!=-1){
			Food f=Tank.food[i];
			super.hunger-=f.getSize();
			super.lastMeal=f.getType();
			super.lastAction="eat";
			Tank.food[i]=null;
			return true;

		}

		return false;
	}

	private int findPlantFood(){
		for(int i=0; i<Tank.food.length; i++)
		{
			if(Tank.food[i]!=null && Tank.food[i].getType().equalsIgnoreCase("plant"))
			{
				return i;
			}
		}
		return -1;
	}



	private boolean eatFish(){
		int fish_Index=findEdibleFish();
		if(fish_Index!=-1){
			super.hunger-=Tank.fish[fish_Index].getSize();
			super.tiredness+=1;
			super.lastAction="eat";
			super.lastMeal=("fish"+fish_Index);
			Tank.fish[fish_Index].setDead(true);
			return true;
		}
		return false;
	}


	private int findEdibleFish(){
		for (int i=0; i<Tank.fish.length; i++)
		{
			if(this.getSpeed()>Tank.fish[i].getSpeed() && Tank.fish[i].getSize()<(this.getSize()+2) && !Tank.fish[i].getDead()){		
				return i;
			}
		}

		return -1;
	}

	@Override
	public boolean sleep() {
		boolean slept=false;
		if(super.tiredness>7)
		{
			super.tiredness-=4;
			super.hunger+=2;
			slept=true;
			super.lastAction="sleep";
		}
		return slept;
	}

	@Override
	public void step() {
		
		if(super.getDead()==false){
			if(this.grow()==false)
			{
				if(this.eat()==false)
				{
					if(this.sleep()==false){
						super.setLastAction("no action");
					}
				}
			}
			checkDeath();
		}
		checkVariableLimits();
	}

	@Override
	public String getFishType() {
		return "Omnivore";
	}

	@Override
	public boolean checkDeath() {
		if(super.hunger>=10){
			super.dead=true;
			super.hunger=10;
		}
		if(super.tiredness>=10){
			super.tiredness=10;
			super.dead=true;
		}
		return dead;
	}
}
