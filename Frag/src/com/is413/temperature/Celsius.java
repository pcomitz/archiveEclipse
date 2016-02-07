package com.is413.temperature;
 
public class Celsius
{
	private float value; 
	
	public Celsius(String c) 
	{
			this.value = Float.parseFloat(c);
	}
		
	//c to f
	public String convert()
	{
		float fahrenheit; 
		fahrenheit = ((9.0f / 5.0f) * value) + 32.0f;
		return new Float(fahrenheit).toString(); 	
	}
}


