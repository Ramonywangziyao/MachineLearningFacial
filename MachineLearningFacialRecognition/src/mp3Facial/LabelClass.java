package mp3Facial;

public class LabelClass {
	public LabelClass(int label)
	{
		this.lable = label;
		for(int i =0;i<70;i++)
		{
			for(int j = 0;j<60;j++)
			{
				pixelLocation[i][j] = new Feature();
			}
		}
	}
	//public double [][] pixelEmptyTotal = new double[70][60];//for training
	//public double [][] pixelPoundTotal = new double[70][60];//for training
	public Feature [][] pixelLocation = new Feature[70][60];
	public int lable;
	public double totalInSample;
	public double myPrior;
	public Feature [][] probability = new Feature[70][60];
}
