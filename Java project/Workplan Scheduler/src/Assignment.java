public abstract class Assignment
{
	/*
Important:
- Store 2 types of information   Date / Test                                  
*/

// Fields 
private Date date;
private String test;
private boolean vacate;


//Constructor
public Assignment(int day, int month, int year, String test, boolean vacate)
{
super(day, month, year);
this.date = new date(day, month, year);
this.vacate = vacate;
}
   
// Methods
// setters / getters

// Først sættes datoen.
public Date setDate(Date date)
{
   this.date = date;
}

public Date getDate()
{
   return date;
}

// Dernæst selve testen.
public String setTest(String test)
{
this.test = test;   
}

public String getTest()
{
   return test;
}

// Dernæst ferien "Vecate".
public String setVecate(String vacate)
{
this.vacate = vacate;   
}

public String getVacate()
{
return vacate;
}

public String isThereAVacate(Object vacate)
{
	if (!(Object instanceof vacate ))
	{
		return false; // (arbejde er sat som default)
		else
		return true;
	}
		
}


}