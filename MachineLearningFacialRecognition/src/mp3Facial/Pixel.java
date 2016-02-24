package mp3Facial;

public class Pixel {
	private int i;
	private int j;
	private int feature;    //  0: space    1: +    2:  #
	private int label;
	private double probability;
	public Pixel()
	{
		
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
