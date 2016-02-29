package mp3Facial;

public class Pixel {
	private int i;
	private int j;
	private int feature;    //  0: space    1: +    2:  #
	private int label;
	private double probability;
	private int red;
	private int green;
	private int blue;
	public Pixel()
	{
		
	}
	public int getRed()
	{
		return red;
	}
	
	public void setRed(int value)
	{
		this.red = value;
	}
	public int getGreen()
	{
		return green;
	}
	
	public void setGreen(int value)
	{
		this.green = value;
	}
	public int getBlue()
	{
		return blue;
	}
	
	public void setBlue(int value)
	{
		this.blue = value;
	}
	public Pixel(int i, int j, int feature)
	{
		this.i = i;
		this.j = j;
		this.feature = feature;
	}
	
	public int getI()
	{
		return i;
	}
	
	public void setI(int value)
	{
		this.i = value;
	}
	
	public int getJ()
	{
		return j;
	}
	
	public void setJ(int value)
	{
		this.j = value;
	}
	
	public int getFeature()
	{
		return feature;
	}
	
	public void setFeature(int value)
	{
		this.feature = value;
	}
	
	public double getProbability()
	{
		return this.probability;
	}
	
	public void setProbability(double value)
	{
		this.probability = value;
	}
	
}
