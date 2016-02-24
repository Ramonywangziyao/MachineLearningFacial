package mp3Facial;

public class ProbabilityCalculation {
	
	public double pixelProbability(double frequencyOfLabel, double totalNumberOfLabel)
	{
		return (frequencyOfLabel+14)/(totalNumberOfLabel+14*2);
	}
	
	
	public double prior(double totalNumberOfLabel, double totalNumberOfSample)
	{
		return totalNumberOfLabel/totalNumberOfSample;
	}
	
	public double odds()
	{
		return 0.0;
	}
	
	public double testingProbability(GraphicImage temp, double priorNumber) throws InterruptedException      //smoothing must be included with constant k from 0-50
	{
		double mapAnswer=0.000000;
		for(int i = 0;i<70;i++)
		{
			for(int j = 0;j<60;j++)
			{
				mapAnswer+=Math.log10(temp.pixelImage[i][j].getProbability());
			}
		}
		mapAnswer+=Math.log10(priorNumber);
		return mapAnswer;
	}
	
	
}
