/* Rashad Saab */

public abstract class Fish{
	protected int size; 			// size should be between 1 and 10 inclusive
	protected int speed;			// speed should be between 1 and 10 inclusive
	protected int hunger;			// hunger should be between 0 and 10 inclusive
	protected int tiredness;		// tiredness should be between 0 and 10 inclusive
	protected boolean dead;
	protected String lastMeal; 	// last meal of the fish
	protected String lastAction;  //one of four: “sleep”, “eat”,  ”grow” or ”no action”

public void checkVariableLimits(){
		if(size>10){
			size=10;
		}
		if(speed>10){
			speed=10;
		}
		if(hunger>10){
			hunger=10;
		}else if(hunger<0){
			hunger=0;
		}
		if(tiredness>10){
			tiredness=10;
		}
	}
	
	/**
	* Constructor for objects of classFish
	*/
	public Fish() {
		this.size=(int) (1+Math.random()*10);
		this.speed=(int) (1+Math.random()*10);
		this.hunger=(int) (Math.random()*10);
		this.tiredness=(int) (Math.random()*10);
		this.lastAction="no action";
		this.lastMeal="";
		this.dead=false;
	}
	
	public Fish (int speed, int size, int hunger, int tiredness){
		this.speed=speed;
		this.size=size;
		this.hunger=hunger;
		this.tiredness=tiredness;
		this.lastAction="no action";
		this.dead=false;
	}
	
	public abstract boolean grow(); // true if success else false
	public abstract boolean eat();	// true if success else false
	public abstract boolean sleep();// true if success else false
	public abstract void step();
	public abstract String getFishType();
	public abstract boolean checkDeath();

	/**
	* returns the size of the Fish
	*/
	public int getSize() {
		return size;
	}

	/**
	* mutator method to set the size of the Fish
	* size should be between 1 and 10 inclusive.
	*@param int the value of type int
	*/
	public void setSize(int size) {
		if(size<1){
			this.size=1;
		}else if(size>10){
			this.size=10;
		}else {
			this.size=size;
		}
	}

	/**
	* returns the speed of the Fish
	*/
	public int getSpeed() {
		return speed;
	}

	/**
	* mutator method to set the speed of the Fish
	* speed should be between 1 and 10 inclusive
	*@param int the value of type int
	*/
	public void setSpeed(int speed) {
		if(speed<1){
			this.speed=1;
		}else if(speed>10){
			this.speed=10;
		}else {
			this.speed=speed;
		}
	}

	/**
	* returns the hunger of the Fish
	*/
	public int getHunger() {
		return hunger;
	}

	/**
	* mutator method to set the hunger of the Fish
	* hunger should be between 0 and 10 inclusive
	*@param int the value of type int
	*/
	public void setHunger(int hunger) {
		if(hunger<0){
			this.hunger=0;
		}else if(hunger>=10){
			this.dead=true;
		}else{
			this.hunger=hunger;
		}
	}

	/**
	 * returns the tiredness of the Fish
	 */
	public int getTiredness() {
		return tiredness;
	}

	/**
	* mutator method to set the tiredness of the Fish
	* tiredness should be between 0 and 10 inclusive
	*@param int the value of type int
	*/
	public void setTiredness(int tiredness) {
		if(tiredness<0){
			this.tiredness=0;
		}else if(tiredness>=10){
			this.dead=true;
		}else{
			this.tiredness=tiredness;
		}
	}

	/**
	* returns the dead of the Fish
	*/
	public boolean getDead() {
		return dead;
	}

	/**
	* mutator method to set the dead of the Fish
	*@param boolean the value of type boolean
	*/
	public void setDead(boolean dead) {
		this.dead=dead;
	}

	/**
	* returns the lastMeal of the Fish
	*/
	public String getLastMeal() {
		return lastMeal;
	}

	/**
	* mutator method to set the lastMeal of the Fish
	*@param String the value of type String
	*/
	public void setLastMeal(String lastMeal) {
		this.lastMeal=lastMeal;
	}

	/**
	* returns the lastAction of the Fish
	*/
	public String getLastAction() {
		return lastAction;
	}

	/**
	* mutator method to set the lastAction of the Fish
	*@param String the value of type String
	*/
	public void setLastAction(String lastAction) {
		this.lastAction=lastAction;
	}


	/**
	* Returns a string object representing this Fish value.
	* The result is a string of 7 line(s) where each line is in turn
	* the string representation of the corresponding instance field.
	* @return a string representation of this object.
	*/
	public String toString() {
		String s= "";
		s+="size = " + size;
		s+="\nspeed = " + speed;
		s+="\nhunger = " + hunger;
		s+="\ntiredness = " + tiredness;
		s+="\ndead = " + dead;
		s+="\nlastMeal = " + lastMeal;
		s+="\nlastAction = " + lastAction;
		return s;
	}

}
