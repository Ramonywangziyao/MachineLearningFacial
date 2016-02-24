package mp3Facial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JComponent;

public class Evaluation extends JComponent implements ActionListener{
	LabelClass[] drawCounts;
	public Evaluation(Queue<GraphicImage> imageList,LabelClass[] labelCounts) throws NumberFormatException, IOException
	{
		drawCounts = labelCounts;
		String labelFile = "src/facedatatestlabels.txt";
		String labelline;
		double [] totalSepLabel = new double [2];
		double [] correctSepLabel = new double [2];
		double correctTotal = 0.0000;
		int[][] wrongRightMatrix = new int[2][2];
		Queue<Integer> labelLists = new LinkedList<Integer>();
		FileReader labelReader = new FileReader(labelFile);
		BufferedReader labelBuffer = new BufferedReader(labelReader);
		DecimalFormat df2 = new DecimalFormat("00.00");
		while((labelline = labelBuffer.readLine())!=null)
		{
			int label = Integer.parseInt(labelline);
			totalSepLabel[label]+=1.0;
			int tempLabel = imageList.poll().getLabel();
//			System.out.println(tempLabel+"   "+label);
			if(tempLabel==label)
			{
				correctTotal+=1;
				correctSepLabel[tempLabel]+=1.0;
				
			}
			else
			{
				wrongRightMatrix[tempLabel][label]+=1;
			}
			labelLists.add(label);
		}
		double correctRate = correctTotal/(double)labelLists.size();
		System.out.println("The correct rate is:    "+correctRate*100+"%");
		for(int i = 0;i<2;i++)
		{
			System.out.println("The accuracy for label "+i+" is:    "+df2.format(((double)correctSepLabel[i]/(double)totalSepLabel[i])*100)+"%");
		}
		for(int i = 0;i<2;i++)
		{
			if(i==0)
			{
				for(int k = 0;k<2;k++)
				{
					if(k==0)
					{System.out.print("test/labl"+k);}
					else
					{
						System.out.print("             "+k);
					}
					
				}
				System.out.println();
			}
			System.out.print(i+"        ");
			for(int j = 0;j<2;j++)
			{
				
				if(i==j)
				{
					System.out.print((df2.format(((double)correctSepLabel[i]/(double)totalSepLabel[i])*100))+"%"+"        ");
				}else
				{
					System.out.print((df2.format(((double)wrongRightMatrix[i][j]/(double)totalSepLabel[i])*100))+"%"+"        ");
				}
			}
			System.out.println();
		}
		//display
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.repaint();
	}


	
	public void paintComponent(Graphics g)
	{
		int[][] rgb = {
				{0,0,149},
				{0,0,177},
				{0,0,195},
				{0,0,227},
				{0, 0, 250},
				{0, 44, 255},
				{0, 67, 255},
				{0, 88, 255},
				{0, 113, 255},
				{0, 156, 255},
				{0, 189, 255},
				{0, 210, 255},
				{0, 233, 255},
				{0, 255, 255},
				{0, 255, 222},
				{0, 255, 205},
				{103, 255, 138},
				{126, 255, 114},
				{204, 255, 0}, 
				{222, 255, 0}, 
				{231, 255, 0}, 
				{244, 255, 0},
				{255, 255, 0}, 
				{255, 235, 0},
				{255, 224, 0},
				{255, 201 ,0},
				{255, 174, 0}, 
				{255, 128, 0},
				{255, 98, 0},
				{255, 78, 0},
				{255, 40, 0},
				{255, 0, 0},
				{234, 0, 0},
				{198, 0, 0},
				{177, 0, 0},
				{147, 0, 0},
				{135, 0, 0}
	          };
		for(int i =0;i<70;i++)
		{
			for(int j = 0;j<60;j++)
			{
				double temp = Math.round((drawCounts[1].probability[i][j].in)*100.0)/100.0;		
				//double odd = Math.round((drawCounts[4].probability[i][j].in/drawCounts[9].probability[i][j].in)*100.0)/100.0;
				//System.out.println(temp);
				
				int newValue = (int)Math.round(temp*MoverImage.mul);
				//int newValue = (int)Math.round(odd*1.8);
				if(newValue>=37)
					newValue = 36;
				Color newC = new Color(rgb[newValue][0],rgb[newValue][1],rgb[newValue][2]);
				g.setColor(newC);
				g.fillRect(j*5, i*5, 5, 5);
				g.setColor(Color.white);
				g.drawString("Amplifier Value:  "+MoverImage.mul, 20,335);
				repaint();
			
			}
		}
	
	}
}
