package is413Temperature;

/*
 * Compile with
 * javac is413Temperature/*.java

 */

public class Fahrenheit
{
	private float value;

	public Fahrenheit(String f)
	{
			this.value = Float.parseFloat(f);
	}


	//f to c
	public String convert()
	{
		float celsius;
		celsius = 5.0f / 9.0f * ( value - 32.0f );
		return new Float(celsius).toString();
	}
}


