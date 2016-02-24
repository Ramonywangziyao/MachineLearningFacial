package mp3Facial;

public class GraphicImage {
	Pixel [][] pixelImage = new Pixel[70][60];
	private int label;
	public double map;
	
	public MapClass[] Probability = new MapClass[10]; //for testing
	
	public GraphicImage()
	{
		
	}
	
	public GraphicImage(Pixel[][] image, int label, int probability)
	{
		this.label = label;
		//this.probability = probability;
		this.pixelImage = image;
	}
	
	public Pixel[][] getPixelImage()
	{
		return pixelImage;
	}
	
	public void setPixelImage(Pixel[][] image)
	{
		this.pixelImage = image;
	}
	
	public int getLabel()
	{
		return this.label;
	}
	
	public void setLabel(int value)
	{
		this.label = value;
	}
}
