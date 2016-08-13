/* Rashad Saab */

public class HerbivoresFish extends Fish {

	public HerbivoresFish() {

	}

	@Override
	public boolean grow() {
		boolean grew=false;
		if(super.hunger<5 && super.tiredness<5)
		{//Size, hunger and tiredness increase by 1
			super.size+=1;
			super.hunger+=1;
			super.tiredness+=1;
			super.lastAction="grow";
			grew= true;
		}
		return grew;
	}

	@Override
	public boolean eat() {
		if (super.hunger>7){
			int index=findEdiblePlantFood();
			if(index!=-1){
				Food f=Tank.food[index];
				super.hunger-=f.getSize();
				super.lastMeal="Plant";
				super.lastAction="eat";
				Tank.food[index]=null;
				return true;
			}
		}
		return false;
	}

	private int findEdiblePlantFood(){
		for(int i=0; i<Tank.food.length; i++)
		{
			if(Tank.food[i]!=null && Tank.food[i].getType().equalsIgnoreCase("Plant"))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean sleep() {
		if(super.tiredness>6)
		{
			super.tiredness-=3;
			super.lastAction="sleep";
			return true;
		}
		return false;
	}

	@Override
	public void step() {

		if(super.getDead()==false){
			if(this.sleep()==false)
			{
				if(this.grow()==false)
				{
					if(this.eat()==false){
						super.setLastAction("no action");
					}
				}
			}
			checkDeath();
		}
		
		checkVariableLimits();
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

	@Override
	public String getFishType() {
		return "Herbivore";
	}

}
