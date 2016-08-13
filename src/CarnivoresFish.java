/* Rashad Saab */

public class CarnivoresFish extends Fish {

	public CarnivoresFish() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean grow() {
		if(super.hunger<6 && super.tiredness<5){
			super.size+=2;
			super.hunger+=3;
			super.lastAction="grow";
			return true;
		}
		return false;
	}

	@Override
	public boolean eat() {
		boolean ate=false;
		if(super.hunger>6){		
			int decision_token=(int)(Math.random()*2);
			if(decision_token==0){
				ate=eatFood();
				if(ate==false){
					eatFish();
				}
			}else if (decision_token==1){
				ate=eatFish();
				if(ate==false){
					eatFood();
				}
			}
		}
		return ate;
	}

	private boolean eatFood(){
		int index=findMeatFood();
		boolean ate=false;
		if(index!=-1){
			Food f=Tank.food[index];
			int foodSize=f.getSize();
			super.hunger-=foodSize;
			super.tiredness+=(foodSize/3);
			super.lastAction="eat";
			super.lastMeal="meat";
			Tank.food[index]=null;
			ate= true;
		}
		
		return ate;
	}
	
	private int findMeatFood() {
		for(int i=0; i<Tank.food.length; i++)
		{
			if(Tank.food[i]!=null && Tank.food[i].getType().equalsIgnoreCase("meat")){
				return i;
			}
		}
		return -1;
	}

	private boolean eatFish(){
		boolean ate=false;
		int fish_Index=findEdibleFish();
		if(fish_Index!=-1){
			super.hunger-=Tank.fish[fish_Index].getSize();
			int n=(int) Math.floor(tiredness/3.0);
			super.tiredness+=n;
			super.lastAction="eat";
			super.lastMeal=("fish"+fish_Index);
			Tank.fish[fish_Index].setDead(true);
			ate= true;
		}
		return ate;
	}


	private int findEdibleFish(){
		for (int i=0; i<Tank.fish.length; i++)
		{
			if(super.getSpeed()>Tank.fish[i].getSpeed() && Tank.fish[i].getSize()<(this.getSize()-2) && !Tank.fish[i].getDead()){		
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean sleep() {
		if(super.tiredness>7){
			super.tiredness-=-2;
			super.lastAction="sleep";
			return true;
		}
		return false;
	}

	@Override
	public void step() {
		if(super.getDead()==false){
			if(this.eat()==false)
			{
				if(this.sleep()==false)
				{
					if(this.grow()==false){
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
		return "Carnivore";
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
