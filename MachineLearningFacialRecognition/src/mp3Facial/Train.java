package mp3Facial;

import java.util.Queue;

public class Train {

	
	public void trainData(LabelClass[] labelCounts) throws InterruptedException
	{
	   ProbabilityCalculation calculator = new ProbabilityCalculation();
	   for(int n = 0;n<2;n++)
	   {
	    	for(int i =0;i<70;i++)
	    	{
	    		for(int j = 0;j<60;j++)
	    		{
	    			for(int r=0;r<225;r++)
	    			{
	    				for(int g=0;g<225;g++)
	    				{
	    					for(int b=0;b<225;b++)
	    					{
	    						labelCounts[n].probability[i][j] = new Feature();
	    						labelCounts[n].probability[i][j].rgbMap[r][g][b] = calculator.pixelProbability(labelCounts[n].pixelLocation[i][j].rgbMap[r][g][b], labelCounts[n].totalInSample);
	    						/** Original Method
	    						labelCounts[n].probability[i][j].e = calculator.pixelProbability(labelCounts[n].pixelEmptyTotal[i][j], labelCounts[n].totalInSample);
	    						labelCounts[n].probability[i][j].in = calculator.pixelProbability(labelCounts[n].pixelPoundTotal[i][j], labelCounts[n].totalInSample);
	    						 **/
	    					}
	    				}
	    			}
	    		}
	    	}//total image numbers
	    	labelCounts[n].myPrior = calculator.prior(labelCounts[n].totalInSample, 5000);
	   }
	}
}
