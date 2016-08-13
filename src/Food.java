/* Rashad Saab */

public class Food{
	private String type; // takes one of two possible values: “Plant” or “Meat”
	private int size;	// size can be 1, 2 or 3

	/**
	* Constructor for objects of class Food
	*/
	public Food() {
		String[] types={"Plant", "Meat"};
		this.type=types[(int) (Math.random()*2)];
		this.size=(int) (1+Math.random()*3);
	}
	
	public Food(String foodType, int foodSize){
		this.type=foodType;
		this.size=foodSize;
	}

	/**
	* returns the type of the Food
	*/
	public String getType() {
		return type;
	}

	/**
	* mutator method to set the type of the Food
	*@param String the value of type String
	*/
	public void setType(String type) {
		this.type=type;
	}

	/**
	* returns the size of the Food
	*/
	public int getSize() {
		return size;
	}

	/**
	* mutator method to set the size of the Food
	*@param int the value of type int
	*/
	public void setSize(int size) {
		this.size=size;
	}


	/**
	* Returns a string object representing this Food value.
	* The result is a string of 2 line(s) where each line is in turn
	* the string representation of the corresponding instance field.
	* @return a string representation of this object.
	*/
	public String toString() {
		String s= "";
		s+=" type = " + type;
		s+=" size = " + size;
		return s;
	}

}
