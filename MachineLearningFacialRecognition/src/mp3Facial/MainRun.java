package mp3Facial;

import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class MainRun{
	Queue<GraphicImage> tested;
	LabelClass notFace = new LabelClass(0);
	LabelClass isFace = new LabelClass(1);

	LabelClass [] labelCounts = {notFace,isFace};
	Evaluation ev;
	public MainRun() throws IOException, InterruptedException
	{
	Queue<Character> qc = new LinkedList();
	
	String a = "";
	a.length();

	//read Labels	
/*
	String labelFile = "src/facedatatrainlabels.txt";
	String labelline;
	Queue<Integer> labelLists = new LinkedList<Integer>();
	FileReader labelReader = new FileReader(labelFile);
	BufferedReader labelBuffer = new BufferedReader(labelReader);
	while((labelline = labelBuffer.readLine())!=null)
	{
		int label = Integer.parseInt(labelline);
		labelLists.add(label);
	}
	*/	
	
	//read Images
	int totalImageSample = 5000;
	Queue<GraphicImage> imageList = new LinkedList<GraphicImage>();
	String line;
	int numCount = 70;
	int faceCount = 0;
	int numSize = 60;
	int faceSize = 0;
	
	GraphicImage newImage = new GraphicImage();
	String urlFile = "src/faceurl.txt";
	FileReader urlReader = new FileReader(urlFile);
	BufferedReader urlBuffer = new BufferedReader(urlReader);
	String urlline;
	while((urlline = urlBuffer.readLine())!=null)
	{
		URL url = new URL(urlline);
		Image img = ImageIO.read(url);  
		
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        if (newImage.pixelImage == null) 
        {
            newImage.setPixelImage(new Pixel[numCount][numSize]);
        }
        for (int col = 0; col < numSize; col++) 
        {
        	for(int row = 0; row<numCount;row++)
        	{
        		Color mycolor = new Color(bimage.getRGB(row, col));
        		newImage.pixelImage[row][col].setRed(mycolor.getRed());
        		newImage.pixelImage[row][col].setGreen(mycolor.getGreen());
        		newImage.pixelImage[row][col].setBlue(mycolor.getBlue());
        		
        		newImage.pixelImage[row][col] = new Pixel();
        		newImage.pixelImage[row][col].setFeature(Integer.parseInt(mycolor.getRed()+mycolor.getGreen()+mycolor.getBlue()+""));
        		newImage.pixelImage[row][col].setI(row);
        		newImage.pixelImage[row][col].setJ(col);
        		labelCounts[1].pixelLocation[row][col].rgbMap[mycolor.getRed()][mycolor.getGreen()][mycolor.getBlue()] += 1;
        	
            
        		System.out.print(newImage.pixelImage[row][col].getFeature());

        	}
        }
		labelCounts[1].totalInSample+=1;
		newImage.setLabel(1);
	
		imageList.add(newImage);
		newImage = new GraphicImage();
		newImage.setPixelImage(new Pixel[numCount][numSize]);
	}
	
	
	
	
	
	/*
	String fileName = "src/facedatatrain.txt";
	Queue<GraphicImage> imageList = new LinkedList<GraphicImage>();
	String line;
	int numCount = 70;
	int faceCount = 0;
	int numSize = 60;
	int faceSize = 0;
	GraphicImage newImage = new GraphicImage();
	FileReader fr = new FileReader(fileName);
	int x = 0;
	BufferedReader bufferNew = new BufferedReader(fr);
	while((line = bufferNew.readLine())!=null)
	{
		char [] vals = line.toCharArray();
        if (newImage.pixelImage == null) 
        {
            newImage.setPixelImage(new Pixel[numCount][numSize]);
        }
        for (int col = 0; col < numSize; col++) {
        	
        	if(vals[col] == ' ')
        	{
        		newImage.pixelImage[x][col] = new Pixel();
        		newImage.pixelImage[x][col].setFeature(0);
        		newImage.pixelImage[x][col].setI(x);
        		newImage.pixelImage[x][col].setJ(col);
        		labelCounts[labelLists.peek()].pixelEmptyTotal[x][col] += 1;
        	
        	//	}
        	}
        	else
            if(vals[col] == '#')
            {
        		newImage.pixelImage[x][col] = new Pixel();
        		newImage.pixelImage[x][col].setFeature(1);
        		newImage.pixelImage[x][col].setI(x);
        		newImage.pixelImage[x][col].setJ(col);
        		labelCounts[labelLists.peek()].pixelPoundTotal[x][col] += 1;
            }	
            
            System.out.print(newImage.pixelImage[x][col].getFeature());
        }
        x++;
        if(x%70==0&&x!=0)
        {
        	labelCounts[labelLists.peek()].totalInSample+=1;
        	newImage.setLabel(labelLists.poll());
        	
        	imageList.add(newImage);
        	newImage = new GraphicImage();
        	newImage.setPixelImage(new Pixel[numCount][numSize]);
        	x=0;
        }
        
        System.out.println();			
	}
	*/
	Train newTrain = new Train();
	newTrain.trainData(labelCounts);
	System.out.println("Training complete!  Ready to take the test!");
	/*
	Test newTest = new Test();
	tested = newTest.testImages(labelCounts);
	
	ev = new Evaluation(tested,labelCounts);
	*/
	
	}
}