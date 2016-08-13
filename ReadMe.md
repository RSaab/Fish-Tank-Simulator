Fish Kingdom

Table 1. Conditions of method implementation
|-----------|-----------------------------------------------|-------------------|---------------------------|
|			|		eat()*									|		sleep()		|			grow()			|
|-----------|-----------------------------------------------|-------------------|---------------------------|
|Herbivores	|		Hunger > 7								|	Tiredness > 6	|		Hunger < 5			|
|			|			&									|					|			&				|
|			|		Food type is “Plant”					|					|		Tiredness < 5		|
|			|												|					|							|
|			|												|					|							|
|-----------|-----------------------------------------------|-------------------|---------------------------|
|Carnivores	|		Hunger > 6								|	Tiredness > 7	|		Hunger < 6			|
|			|			&									|					|			&				|
|			|		(Food type is “Meat”					|					|		Tiredness < 5		|
|			|			Or 									|					|							|
|			|		Fish slower and smaller by 2 points )**	|					|							|
|			|												|					|							|
|			|												|					|							|
|-----------|-----------------------------------------------|-------------------|---------------------------|
|Omnivores	|		Hunger > 7								|	Tiredness > 7	|		Hunger < 7			|
|			|			&									|					|			&				|
|			|		( Food of any type						|					|		Tiredness < 8		|
|			|			or 									|					|							|
|			|		Fish of slower speed and  size up till	|					|							|
|			|		2 points bigger) ***					|					|							|
|-----------|-----------------------------------------------|-------------------|---------------------------|


Table 2. Actions taken in the method if the conditions were met

|-----------|----------------------------------------|------------------------------|-----------------------------------------------|
|			|	eat()*								 |			sleep()				|					grow()						|
|-----------|----------------------------------------|------------------------------|-----------------------------------------------|
|Herbivores	|Hunger decreases by food size			 |	Tiredness decreases by 3	|	Size, hunger and tiredness increase by 1	|
|-----------|----------------------------------------|------------------------------|-----------------------------------------------|
|Carnivores	|Hunger decreases by food size 			 |	Tiredness decreases by 2	|	Size increases by 2,						|
|			|or fish size 							 |								|	hunger by 3									|
|			|according to what was eaten			 |								|												|
|			|		&								 |								|												|
|			|Tiredness increases by 1/3 of meal size |								|												|
|-----------|----------------------------------------|------------------------------|-----------------------------------------------|														
|Omnivores	|Hunger decreases by food size 			 |	Tiredness decreases by 4	|	Size and speed increase by 1				|
|			|or fish size according to what was eaten|		&						|	Hunger and tiredness increase by 2			|
|			|	&									 |	Hunger increases by 2		|												|
|			|Tiredness increases by 1				 |								|												|
|-----------|----------------------------------------|------------------------------|-----------------------------------------------|

* eat() updates lastMeal with the food. If the food type was “Plant” or “Meat”, just store “Plant” or “Meat” in lastMeal and replace the food object that was eaten with null.  If the food was fish, store in lastMeal the string “fish” concatenated with the array index of the fish that was eaten and turn the isDead to true.
** decision whether food or fish is eaten is chosen randomly. 
*** choice of meal depends on preferredMeal but meeting the conditions in the table. If preferredMeal in not available, it is chosen randomly.

1.	The “step” method: 
	“step” method passes one unit of time. In a step, every fish does only one of 3 possible things: eat, sleep or grow.
	Each fish has different precedence order.
	Herbivores: sleep, grow, eat
	Carnivores: eat, sleep, grow
	Omnivores: grow, eat, sleep
		a.	If the method’s conditions are not met, the fish moves to the next method in its order.
		b.	If none is met the fish does nothing.
		c.	If a fish is dead, it does nothing in the step method.

2.	Add a “step” static method to the Tank class that makes all fish do 1 step. In addition, it increases hunger and tiredness by 1 every 3 steps. 
	By the end of a step, if hunger or tiredness reach 10 the fish dies.

3.	Program Description:
	a.	Fills the tank object randomly
	b.	Prints out the status of the tank attributes of fish and food in the tank
	c.	Asks the user if he wants to step or quit.
