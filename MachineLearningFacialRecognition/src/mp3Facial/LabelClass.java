package mp3Facial;

public class LabelClass {
	public LabelClass(int label)
	{
		this.lable = label;
	}
	public double [][] pixelEmptyTotal = new double[70][60];//for training
	public double [][] pixelPoundTotal = new double[70][60];//for training
	public int lable;
	public double totalInSample;
	public double myPrior;
	public Feature [][] probability = new Feature[70][60];
}
